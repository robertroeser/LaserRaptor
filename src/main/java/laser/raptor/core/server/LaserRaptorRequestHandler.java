package laser.raptor.core.server;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.gs.collections.impl.map.mutable.primitive.LongObjectHashMap;
import io.reactivesocket.Payload;
import io.reactivesocket.RequestHandler;
import laser.raptor.core.MetadataFlyweight;
import laser.raptor.core.serialization.JacksonUtil;
import org.reactivestreams.Publisher;
import rx.Observable;
import rx.RxReactiveStreams;
import uk.co.real_logic.agrona.LangUtil;

import java.nio.ByteBuffer;
import java.util.Set;
import java.util.function.Function;


@SuppressWarnings("unchecked")
public class LaserRaptorRequestHandler extends RequestHandler {
    private static ThreadLocal<MetadataFlyweight> METADATA_FLYWEIGHT = ThreadLocal.withInitial(MetadataFlyweight::new);

    private static final ByteBuffer EMPTY = ByteBuffer.allocate(0);

    private LongObjectHashMap<RequestHandlerMetadata> requestHandlerMetadata = new LongObjectHashMap<>();

    public LaserRaptorRequestHandler(Set<String> servicesToLoad, String... packages) {
        try {
            ClassPath classPath = ClassPath.from(Thread.currentThread().getContextClassLoader());

            for (String p : packages) {
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
                                final Class<Function<Object, Observable>> functionClass = laserRaptorFunction.serviceClassName();
                                final String  serviceName = laserRaptorFunction.serviceClassName().getName();

                                if (servicesToLoad.contains(serviceName)) {
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
        } catch (Exception e) {
            LangUtil.rethrowUnchecked(e);
        }
    }

    @Override
    public Publisher<Payload> handleRequestResponse(Payload payload) {
        return handle(payload);
    }

    @Override
    public Publisher<Payload> handleRequestStream(Payload payload) {
        return handle(payload);
    }

    @Override
    public Publisher<Payload> handleSubscription(Payload payload) {
        return handle(payload);
    }

    @Override
    public Publisher<Void> handleFireAndForget(Payload payload) {
        return RxReactiveStreams.toPublisher(Observable.defer(() -> {
            MetadataFlyweight metadataFlyweight = METADATA_FLYWEIGHT.get();
            metadataFlyweight.wrap(payload.getMetadata());

            RequestHandlerMetadata requestHandlerMetadata
                    = this.requestHandlerMetadata.get(metadataFlyweight.getServiceMethodHash());

            Function<Object, Observable> handler = requestHandlerMetadata.getHandler();

            Object request
                    = JacksonUtil
                    .readValueFromByteBuffer(payload.getData(), requestHandlerMetadata.getRequestClass());

            return handler.apply(request);
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

    public Publisher<Payload> handle(Payload payload) {
        return RxReactiveStreams.toPublisher(Observable
                .defer(() -> {
                    MetadataFlyweight metadataFlyweight = METADATA_FLYWEIGHT.get();
                    metadataFlyweight.wrap(payload.getMetadata());

                    RequestHandlerMetadata requestHandlerMetadata
                            = this.requestHandlerMetadata.get(metadataFlyweight.getServiceMethodHash());

                    Function<Object, Observable> handler = requestHandlerMetadata.getHandler();

                    return handler.apply(payload);
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
