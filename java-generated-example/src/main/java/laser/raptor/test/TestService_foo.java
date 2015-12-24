// GENERATED ON Wed Dec 23 18:07:23 PST 2015 BY LASER RAPTOR VERSION 1.0.0
package laser.raptor.test;

import laser.raptor.core.server.LaserRaptorServerFunctionMetadata;
import laser.raptor.core.server.server_functions.RequestResponseServerFunction;
import rx.Observable;

import java.util.Date;

@LaserRaptorServerFunctionMetadata(
        hash = 436260267547043L,
        methodId = 101574,
        requestClass = TestMessageRequest.class,
        responseClass = TestMessageResponse.class,
        serviceClass = TestService_foo.class,
        serviceId = -1035544157)
public class TestService_foo implements RequestResponseServerFunction<TestMessageRequest, TestMessageResponse> {
    @Override
    public Observable<TestMessageResponse> apply(Observable<TestMessageRequest> testMessageRequestObservable) {
        return testMessageRequestObservable
            .map(request -> {
                String aString = request.getAString();
                System.out.println("pong got => " + aString);

                TestMessageResponse response = new TestMessageResponse();
                response.setAString("Pong sending a string at " + new Date());

                return response;
            });
    }
}

