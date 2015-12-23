package laser.raptor.core.server;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
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

                            requestHandlerMetadata.put(laserRaptorFunction.hash(), metadata);
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
        throw new UnsupportedOperationException("channel not supported yet");
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

            }));
    }
}
