// GENERATED ON Fri Jan 01 22:07:50 PST 2016 BY LASER RAPTOR VERSION 1.0.0
package laser.raptor.test;

import laser.raptor.core.server.LaserRaptorServerFunctionMetadata;
import laser.raptor.core.server.server_functions.RequestResponseServerFunction;
import rx.Observable;

@LaserRaptorServerFunctionMetadata(
        hash =  436260267547043L,
        methodId = 101574,
        serviceName =  "TestService",
        methodName =  "foo",
        requestClass = TestMessageRequest.class,
        responseClass = TestMessageResponse.class,
        serviceClass = TestService_foo.class,
        serviceId = -1035544157)
public class TestService_foo implements RequestResponseServerFunction<TestMessageRequest, TestMessageResponse> {
    @Override
    public Observable<TestMessageResponse> apply(Observable<TestMessageRequest> testMessageRequestObservable) {
        return testMessageRequestObservable
            .map(testMessageRequest -> {
                String aString = testMessageRequest.getAString();
                TestMessageResponse response = new TestMessageResponse();
                response.setAString("A new string => " + aString);
                return response;
            });
    }
}

