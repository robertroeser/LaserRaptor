// GENERATED ON Fri Jan 01 22:01:31 PST 2016 BY LASER RAPTOR VERSION 1.0.0
package laser.raptor.test;

import io.reactivesocket.Payload;
import laser.raptor.core.client.LaserRaptorClientService;
import laser.raptor.core.client.LaserRaptorClientServiceFactory;
import laser.raptor.core.client.ReactiveSocketLoadBalancer;
import laser.raptor.core.serialization.JacksonUtil;
import rx.Observable;

import java.nio.ByteBuffer;


public class TestService extends LaserRaptorClientService {
protected TestService() {}

protected TestService(ReactiveSocketLoadBalancer reactiveSocketLoadBalancer) {
super(reactiveSocketLoadBalancer);
}

    public Observable<TestMessageResponse> foo(TestMessageRequest testMessageRequestObservable) {
        Observable<Payload> defer = Observable.<Payload>defer(() -> {
            ByteBuffer requestBuffer = JacksonUtil.writeValueAsByteBuffer(testMessageRequestObservable);
            return handleRequestResponse(-1035544157, 101574, requestBuffer);
        });

        return defer.map(payload -> {
            ByteBuffer responseBuffer = payload.getData();
            return JacksonUtil.readValueFromByteBuffer(responseBuffer, TestMessageResponse.class);
        });
    }


public static TestService getInstance(
ReactiveSocketLoadBalancer.SocketAddressFactory socketAddressFactory,
ReactiveSocketLoadBalancer.ClosedConnectionsProvider closedConnectionsProvider) {
return LaserRaptorClientServiceFactory
.getLaserRaptorService(
TestService.class,
socketAddressFactory,
closedConnectionsProvider,
ReactiveSocketLoadBalancer.WEB_SOCKET_FACTORY,
ReactiveSocketLoadBalancer.LEAST_LOADED_SELECTOR);
}

public static TestService getInstance(ReactiveSocketLoadBalancer.SocketAddressFactory socketAddressFactory) {
return LaserRaptorClientServiceFactory
.getLaserRaptorService(
TestService.class,
socketAddressFactory,
ReactiveSocketLoadBalancer.NO_CHANGE_PROVIDER,
ReactiveSocketLoadBalancer.WEB_SOCKET_FACTORY,
ReactiveSocketLoadBalancer.LEAST_LOADED_SELECTOR);
}
}