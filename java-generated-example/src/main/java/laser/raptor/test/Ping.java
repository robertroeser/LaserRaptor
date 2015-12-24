package laser.raptor.test;

import laser.raptor.core.client.Resolver;
import rx.Observable;

public class Ping {
    public static void main(String... args) {
        TestService instance = TestService.getInstance(new Resolver() {
            @Override
            public String host() {
                return "localhost";
            }

            @Override
            public int port() {
                return 8888;
            }
        });

        Observable
            .range(0, 100)
            .flatMap(i -> {
                System.out.println("sending " + i);
                TestMessageRequest testMessageRequest = new TestMessageRequest();
                testMessageRequest.setAString("message from ping number " + i);
                return instance.foo(testMessageRequest);
            })
            .doOnNext(testMessageResponse -> System.out.println("from pong => " + testMessageResponse.getAString()))
            .toBlocking()
            .lastOrDefault(null);
    }
}
