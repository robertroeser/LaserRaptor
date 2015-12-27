package laser.raptor.test;

import laser.raptor.core.client.ReactiveSocketLoadBalancer;
import rx.Observable;

import java.net.InetSocketAddress;

public class Ping {
    public static void main(String... args) {
        ReactiveSocketLoadBalancer.StaticListFactory staticListFactory = ReactiveSocketLoadBalancer
            .StaticListFactory
            .newInstance(InetSocketAddress.createUnresolved("localhost", 8888));

        TestService instance = TestService.getInstance(staticListFactory);

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
