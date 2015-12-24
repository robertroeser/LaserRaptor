// GENERATED ON Wed Dec 23 18:07:16 PST 2015 BY LASER RAPTOR VERSION 1.0.0
package laser.raptor.test;

import io.reactivesocket.Payload;
import laser.raptor.core.client.LaserRaptorClientService;
import laser.raptor.core.client.LaserRaptorClientServiceFactory;
import laser.raptor.core.client.Resolver;
import laser.raptor.core.serialization.JacksonUtil;
import rx.Observable;

import java.nio.ByteBuffer;

public class TestService extends LaserRaptorClientService {
protected TestService() {}

protected TestService(String host, int port) {
super(host, port);
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


public static TestService getInstance(Resolver resolver) {
return LaserRaptorClientServiceFactory.getLaserRaptorService(TestService.class, resolver);
}
}