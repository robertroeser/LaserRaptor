package laser.raptor.core.server;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.inject.Inject;
import com.gs.collections.impl.map.mutable.primitive.LongObjectHashMap;
import io.reactivesocket.Payload;
import io.reactivesocket.RequestHandler;
import laser.raptor.core.InteractionModel;
import laser.raptor.core.MetadataFlyweight;
import laser.raptor.core.serialization.JacksonUtil;
import laser.raptor.core.server.server_functions.FireAndForgetServerFunction;
import laser.raptor.core.server.server_functions.ServerFunction;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.RxReactiveStreams;
import rx.functions.Action1;
import uk.co.real_logic.agrona.LangUtil;

import java.nio.ByteBuffer;
import java.util.Set;


@SuppressWarnings("unchecked")
public class LaserRaptorRequestHandler extends RequestHandler {
    private static final Logger logger = LoggerFactory.getLogger(LaserRaptorRequestHandler.class);

    private static ThreadLocal<MetadataFlyweight> METADATA_FLYWEIGHT = ThreadLocal.withInitial(MetadataFlyweight::new);

    private static final ByteBuffer EMPTY = ByteBuffer.allocate(0);

    // Visible for Testing
    LongObjectHashMap<RequestHandlerMetadata> requestHandlerMetadata = new LongObjectHashMap<>();

    /**
     * This constructor is used by Guice to inject a set of already construct ServerFunctions into the handler.
     *
     * @param serverFunctions set of server functions to inject
     */
    @Inject
    public LaserRaptorRequestHandler(Set<ServerFunction> serverFunctions) {
        serverFunctions
            .stream()
            .forEach(serverFunction -> {
                Class<? extends ServerFunction> serverFunctionClass = serverFunction.getClass();
                LaserRaptorServerFunctionMetadata laserRaptorFunction = serverFunctionClass.getAnnotation(LaserRaptorServerFunctionMetadata.class);
                RequestHandlerMetadata metadata =
                    new RequestHandlerMetadata(
                        laserRaptorFunction.methodId(),
                        laserRaptorFunction.serviceName(),
                        laserRaptorFunction.requestClass(),
                        laserRaptorFunction.responseClass(),
                        serverFunction);

                requestHandlerMetadata.put(laserRaptorFunction.hash(), metadata);
            });
    }

    /**
     * Use this constructor if you don't use Guice. The constructor will can the class path and load the implementations
     * you specify.
     *
     * @param servicesToLoad The services to load
     * @param packages The packages to scan
     */
    public LaserRaptorRequestHandler(Set<String> servicesToLoad, String... packages) {
        scanPackages(servicesToLoad, packages);
    }

    // Constructor for Testing
    LaserRaptorRequestHandler() {}

    protected void scanPackages(Set<String> servicesToLoad, String... packages) {
        try {
            ClassPath classPath = ClassPath.from(Thread.currentThread().getContextClassLoader());

            for (String p : packages) {
                logger.info("Scanning package {}", p);
                scanPackage(classPath, servicesToLoad, p);
            }
        } catch (Exception e) {
            LangUtil.rethrowUnchecked(e);
        }
    }


    protected void scanPackage(ClassPath classPath, Set<String> servicesToLoad, String p)  {
        ImmutableSet<ClassPath.ClassInfo> topLevelClassesRecursive =
                classPath.getTopLevelClassesRecursive(p);

        topLevelClassesRecursive
                .parallelStream()
                .filter(classInfo -> {
                    Class<?> load = classInfo.load();
                    return load.getDeclaredAnnotation(LaserRaptorServerFunctionMetadata.class) != null;
                })
                .map(classInfo -> classInfo.load().getDeclaredAnnotation(LaserRaptorServerFunctionMetadata.class))
                .forEach(laserRaptorFunction -> {
                    try {
                        Class<? extends ServerFunction> functionClass = laserRaptorFunction.serviceClass();
                        final String  serviceName = laserRaptorFunction.serviceClass().getName();
                        logger.info("Found LaserRaptor Service named {} ", serviceName);

                        if (servicesToLoad.contains(serviceName)) {
                            logger.info("LaserRaptor Service named {} is in set of services to load", serviceName);
                            RequestHandlerMetadata metadata =
                                    new RequestHandlerMetadata(
                                            laserRaptorFunction.methodId(),
                                            serviceName,
                                            laserRaptorFunction.requestClass(),
                                            laserRaptorFunction.responseClass(),
                                            functionClass.newInstance());

                            logger.info("Loaded LaserRaptor Service with meta data {}", metadata);

                            requestHandlerMetadata.put(laserRaptorFunction.hash(), metadata);
                        } else {
                            logger.info("Found service named {} but not on list of services to load so skipping", serviceName);
                        }
                    } catch (Exception e) {
                        LangUtil.rethrowUnchecked(e);
                    }

                });
    }

    @Override
    public Publisher<Payload> handleRequestResponse(Payload payload) {
        return handle(payload, InteractionModel.REQUEST_RESPONSE);
    }

    @Override
    public Publisher<Payload> handleRequestStream(Payload payload) {
        return handle(payload, InteractionModel.REQUEST_STREAM);
    }

    @Override
    public Publisher<Payload> handleSubscription(Payload payload) {
        return handle(payload, InteractionModel.SUBSCRIPTION);
    }

    @Override
    public Publisher<Void> handleFireAndForget(Payload payload) {
        return RxReactiveStreams.toPublisher(Observable.defer(() -> {
            MetadataFlyweight metadataFlyweight = METADATA_FLYWEIGHT.get();
            metadataFlyweight.wrap(payload.getMetadata());

            RequestHandlerMetadata requestHandlerMetadata
                    = this.requestHandlerMetadata.get(metadataFlyweight.getServiceMethodHash());

            ServerFunction handler = requestHandlerMetadata.getHandler();

            if (!(handler instanceof FireAndForgetServerFunction)) {
                return Observable.error(new IllegalStateException("handler class "
                        + handler.getClass().getName()
                        + " is not expected type => "
                        + InteractionModel.FIRE_AND_FORGET.getFunctionType().getName()));
            }

            Object request
                    = JacksonUtil
                    .readValueFromByteBuffer(payload.getData(), requestHandlerMetadata.getRequestClass());

            Observable just = Observable.just(request);
            return handler.apply(just);
        })
        .ignoreElements());

    }

    @Override
    public Publisher<Payload> handleChannel(Publisher<Payload> inputs) {
        Observable<Payload> handleChannel = RxReactiveStreams
            .toObservable(inputs)
            .flatMap(payload -> RxReactiveStreams.toObservable(handle(payload, InteractionModel.CHANNEL)));

        return RxReactiveStreams.toPublisher(handleChannel);
    }

    @Override
    public Publisher<Void> handleMetadataPush(Payload payload) {
        throw new UnsupportedOperationException("metadatapush not supported yet");
    }

    public Publisher<Payload> handle(Payload payload, InteractionModel model) {
        return RxReactiveStreams.toPublisher(Observable
            .defer(() -> {
                MetadataFlyweight metadataFlyweight = METADATA_FLYWEIGHT.get();
                metadataFlyweight.wrap(payload.getMetadata());

                RequestHandlerMetadata requestHandlerMetadata
                        = this.requestHandlerMetadata.get(metadataFlyweight.getServiceMethodHash());

                ServerFunction handler = requestHandlerMetadata.getHandler();

                if (!model.getFunctionType().isAssignableFrom(handler.getClass())) {
                    return Observable.error(new IllegalStateException("handler class "
                            + handler.getClass().getName()
                            + " is not expected type => "
                            + model.getFunctionType().getName()));
                }

                Object request
                        = JacksonUtil
                        .readValueFromByteBuffer(payload.getData(), requestHandlerMetadata.getRequestClass());

                Observable just = Observable.just(request);
                return handler.apply(just);
            })
            .map(response -> {
                final ByteBuffer responseBytes = JacksonUtil.writeValueAsByteBuffer(response);

                return new Payload() {
                    @Override
                    public ByteBuffer getData() {
                        return responseBytes;
                    }

                    @Override
                    public ByteBuffer getMetadata() {
                        return EMPTY;
                    }
                };

            }).doOnError(new Action1<Throwable>() {
                @Override
                public void call(Throwable throwable) {
                    logger.error("an error occurred processing the request", throwable);
                }
            }));
    }
}
