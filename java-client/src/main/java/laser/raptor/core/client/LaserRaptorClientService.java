package laser.raptor.core.client;

import io.reactivesocket.ConnectionSetupPayload;
import io.reactivesocket.Payload;
import io.reactivesocket.ReactiveSocket;
import io.reactivesocket.websocket.rxnetty.WebSocketDuplexConnection;
import io.reactivex.netty.protocol.http.client.HttpClient;
import io.reactivex.netty.protocol.http.ws.WebSocketConnection;
import io.reactivex.netty.protocol.http.ws.client.WebSocketResponse;
import laser.raptor.core.MetadataFlyweight;
import org.reactivestreams.Publisher;
import rx.Observable;
import rx.RxReactiveStreams;

import java.nio.ByteBuffer;

public abstract class LaserRaptorClientService<I, O> {
    private static final ThreadLocal<MetadataFlyweight> METADATA_FLYWEIGHT = ThreadLocal.withInitial(MetadataFlyweight::new);

    private ReactiveSocket reactiveSocket;

    // Constructor for testing
    protected LaserRaptorClientService() {}

    protected LaserRaptorClientService(String host, int port) {
        Observable<WebSocketConnection> wsConnection = HttpClient.newClient(host, port)
                //.enableWireLogging(LogLevel.ERROR)
                .createGet("/rs")
                .requestWebSocketUpgrade()
                .flatMap(WebSocketResponse::getWebSocketConnection);

        Publisher<WebSocketDuplexConnection> connectionPublisher =
                WebSocketDuplexConnection.create(RxReactiveStreams.toPublisher(wsConnection));

        reactiveSocket = RxReactiveStreams
                .toObservable(connectionPublisher)
                .map(w -> ReactiveSocket.fromClientConnection(w, ConnectionSetupPayload.create("UTF-8", "UTF-8")))
                .toBlocking()
                .single();

        reactiveSocket.startAndWait();
    }

    protected final Observable<Void> handleFireAndForget(int serviceId, int methodId, ByteBuffer data) {
        return Observable
                .defer(() -> {
                    Payload payload = createPayload(serviceId, methodId, data);

                    return RxReactiveStreams.toObservable(reactiveSocket.fireAndForget(payload));
                });
    }

    protected final  Observable<Payload> handleRequestResponse(int serviceId, int methodId, ByteBuffer data) {
        return Observable
                .defer(() -> {
                    Payload payload = createPayload(serviceId, methodId, data);
                    return RxReactiveStreams.toObservable(reactiveSocket.requestResponse(payload));
                });
    }

    protected final  Observable<Payload> handleRequestStream(int serviceId, int methodId, ByteBuffer data) {
        return Observable
                .defer(() -> {
                    Payload payload = createPayload(serviceId, methodId, data);
                    return RxReactiveStreams.toObservable(reactiveSocket.requestStream(payload));
                });
    }

    protected final  Observable<Payload> handleSubscription(int serviceId, int methodId, ByteBuffer data) {
        return Observable
                .defer(() -> {
                    Payload payload = createPayload(serviceId, methodId, data);
                    return RxReactiveStreams.toObservable(reactiveSocket.requestSubscription(payload));
                });
    }

    protected final  Observable<Payload> handleChannel(int serviceId, int methodId, Observable<ByteBuffer> dataObservable) {
        Publisher<Payload> payloadPublisher = RxReactiveStreams
                .toPublisher(dataObservable
                        .map(data -> createPayload(serviceId, methodId, data)));
        return RxReactiveStreams.toObservable(reactiveSocket.requestChannel(payloadPublisher));
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
