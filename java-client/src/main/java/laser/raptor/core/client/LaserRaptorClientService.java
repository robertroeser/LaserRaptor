package laser.raptor.core.client;

import io.reactivesocket.Payload;
import laser.raptor.core.MetadataFlyweight;
import org.reactivestreams.Publisher;
import rx.Observable;
import rx.RxReactiveStreams;

import java.nio.ByteBuffer;

public abstract class LaserRaptorClientService<I, O> {
    private static final ThreadLocal<MetadataFlyweight> METADATA_FLYWEIGHT = ThreadLocal.withInitial(MetadataFlyweight::new);

    private ReactiveSocketLoadBalancer reactiveSocketLoadBalancer;

    // Constructor for testing
    protected LaserRaptorClientService() {}

    protected LaserRaptorClientService(ReactiveSocketLoadBalancer reactiveSocketLoadBalancer) {
        this.reactiveSocketLoadBalancer = reactiveSocketLoadBalancer;
    }

    protected final Observable<Void> handleFireAndForget(int serviceId, int methodId, ByteBuffer data) {
        return reactiveSocketLoadBalancer
            .nextAvailableSocket()
            .flatMap(reactiveSocketHolder -> {
                long start = reactiveSocketHolder.recordStart();
                Payload payload = createPayload(serviceId, methodId, data);
                return RxReactiveStreams
                    .toObservable(reactiveSocketHolder.getReactiveSocket().fireAndForget(payload))
                    .doOnError(t -> reactiveSocketHolder.recordFailure(start))
                    .doOnCompleted(() -> reactiveSocketHolder.recordSuccess(start));
            });
    }

    protected final  Observable<Payload> handleRequestResponse(int serviceId, int methodId, ByteBuffer data) {
        return reactiveSocketLoadBalancer
            .nextAvailableSocket()
            .flatMap(reactiveSocketHolder -> {
                long start = reactiveSocketHolder.recordStart();
                Payload payload = createPayload(serviceId, methodId, data);
                return RxReactiveStreams
                    .toObservable(reactiveSocketHolder.getReactiveSocket().requestResponse(payload))
                    .doOnError(t -> reactiveSocketHolder.recordFailure(start))
                    .doOnCompleted(() -> reactiveSocketHolder.recordSuccess(start));
            });
    }

    protected final  Observable<Payload> handleRequestStream(int serviceId, int methodId, ByteBuffer data) {
        return reactiveSocketLoadBalancer
            .nextAvailableSocket()
            .flatMap(reactiveSocketHolder -> {
                long start = reactiveSocketHolder.recordStart();
                Payload payload = createPayload(serviceId, methodId, data);
                return RxReactiveStreams
                    .toObservable(reactiveSocketHolder.getReactiveSocket().requestStream(payload))
                    .doOnError(t -> reactiveSocketHolder.recordFailure(start))
                    .doOnCompleted(() -> reactiveSocketHolder.recordSuccess(start));
            });
    }

    protected final  Observable<Payload> handleSubscription(int serviceId, int methodId, ByteBuffer data) {
        return reactiveSocketLoadBalancer
            .nextAvailableSocket()
            .flatMap(reactiveSocketHolder -> {
                long start = reactiveSocketHolder.recordStart();
                Payload payload = createPayload(serviceId, methodId, data);
                return RxReactiveStreams
                    .toObservable(reactiveSocketHolder.getReactiveSocket().requestSubscription(payload))
                    .doOnError(t -> reactiveSocketHolder.recordFailure(start))
                    .doOnCompleted(() -> reactiveSocketHolder.recordSuccess(start));
            });
    }

    protected final  Observable<Payload> handleChannel(int serviceId, int methodId, Observable<ByteBuffer> dataObservable) {
        return reactiveSocketLoadBalancer
            .nextAvailableSocket()
            .flatMap(reactiveSocketHolder -> {
                long start = reactiveSocketHolder.recordStart();
                Publisher<Payload> payloadPublisher = RxReactiveStreams
                    .toPublisher(dataObservable
                        .map(data -> createPayload(serviceId, methodId, data)));
                return RxReactiveStreams
                    .toObservable(reactiveSocketHolder.getReactiveSocket().requestChannel(payloadPublisher))
                    .doOnError(t -> reactiveSocketHolder.recordFailure(start))
                    .doOnCompleted(() -> reactiveSocketHolder.recordSuccess(start));
            });
    }

    final Payload createPayload(int serviceId, int methodId, ByteBuffer data) {
        Payload payload = new Payload() {
            @Override
            public ByteBuffer getData() {
                return data;
            }

            @Override
            public ByteBuffer getMetadata() {
                MetadataFlyweight metadataFlyweight = METADATA_FLYWEIGHT.get();
                metadataFlyweight.setServiceId(serviceId);
                metadataFlyweight.setMethodId(methodId);
                return metadataFlyweight.getByteBuffer();
            }
        };

        return payload;
    }
}
