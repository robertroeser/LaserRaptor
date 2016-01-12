package laser.raptor.core.client;

import io.reactivesocket.ReactiveSocket;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ReactiveSocketLoadBalancerTest {
    @Test
    public void testGetNextSocketWithOneAddress() {
        ReactiveSocketLoadBalancer.StaticListFactory socketAddressFactory
            = ReactiveSocketLoadBalancer.StaticListFactory.newInstance(InetSocketAddress.createUnresolved("localhost", 8888));

        ReactiveSocketLoadBalancer.StatsSelector statsSelector = Mockito.mock(ReactiveSocketLoadBalancer.StatsSelector.class);

        ReactiveSocket reactiveSocket = Mockito.mock(ReactiveSocket.class);

        ReactiveSocketLoadBalancer loadBalancer
            = new ReactiveSocketLoadBalancer(
            socketAddressFactory,
            ReactiveSocketLoadBalancer.NO_CHANGE_PROVIDER,
            socketAddress -> reactiveSocket,
            statsSelector);

        Observable<ReactiveSocketStatsHolder> reactiveSocketStatsHolderObservable =
            loadBalancer.nextAvailableSocket();

        TestSubscriber testSubscriber = new TestSubscriber();
        reactiveSocketStatsHolderObservable
            .doOnNext(reactiveSocketStatsHolder -> {
                ReactiveSocket reactiveSocket1 = reactiveSocketStatsHolder.getReactiveSocket();
                Assert.assertEquals(reactiveSocket, reactiveSocket1);
            })
            .subscribe(testSubscriber);

        testSubscriber.awaitTerminalEvent(1, TimeUnit.SECONDS);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);

    }

    @Test
    public void testSelectThreeSockets() {
        ReactiveSocket one = Mockito.mock(ReactiveSocket.class);
        ReactiveSocket two = Mockito.mock(ReactiveSocket.class);
        ReactiveSocket three = Mockito.mock(ReactiveSocket.class);

        InetSocketAddress address1 = InetSocketAddress.createUnresolved("one", 8888);
        InetSocketAddress address2 = InetSocketAddress.createUnresolved("two", 8888);
        InetSocketAddress address3 = InetSocketAddress.createUnresolved("three", 8888);

        ReactiveSocketLoadBalancer.ReactiveSocketFactory reactiveSocketFactory
            = Mockito.mock(ReactiveSocketLoadBalancer.ReactiveSocketFactory.class);

        Mockito.when(reactiveSocketFactory.call(address1)).thenReturn(one);
        Mockito.when(reactiveSocketFactory.call(address2)).thenReturn(two);
        Mockito.when(reactiveSocketFactory.call(address3)).thenReturn(three);

        ReactiveSocketLoadBalancer.StaticListFactory socketAddressFactory
            = ReactiveSocketLoadBalancer
                .StaticListFactory
                .newInstance(address1, address2, address3);

        ReactiveSocketLoadBalancer reactiveSocketLoadBalancer
            = new ReactiveSocketLoadBalancer(
            socketAddressFactory,
            ReactiveSocketLoadBalancer.NO_CHANGE_PROVIDER,
            reactiveSocketFactory,
            ReactiveSocketLoadBalancer.LEAST_LOADED_SELECTOR,
            new ReactiveSocketLoadBalancer.NumberGenerator() {
                AtomicInteger count = new AtomicInteger();
                @Override
                public int nextInt() {
                    return count.getAndIncrement();
                }
            }
        );

        ReactiveSocketStatsHolder statsHolder1 = reactiveSocketLoadBalancer
            .nextAvailableSocket()
            .toBlocking().last();

        long l = statsHolder1.recordStart();
        statsHolder1.recordSuccess(l);

        ReactiveSocketStatsHolder statsHolder2 = reactiveSocketLoadBalancer
            .nextAvailableSocket()
            .toBlocking().last();

        long l1 = statsHolder2.recordStart();
        statsHolder2.recordSuccess(l1);

        ReactiveSocketStatsHolder statsHolder3 = reactiveSocketLoadBalancer
            .nextAvailableSocket()
            .toBlocking().last();

        long l2 = statsHolder3.recordStart();
        statsHolder3.recordSuccess(l2);

        Assert.assertEquals("1", statsHolder1.getReactiveSocket(), one);
        Assert.assertEquals("2", statsHolder2.getReactiveSocket(), three);
        Assert.assertEquals("3", statsHolder3.getReactiveSocket(), two);

    }

    @Test
    public void testSelectMultipleReactiveSockets() {
        ReactiveSocket one = Mockito.mock(ReactiveSocket.class);
        ReactiveSocket two = Mockito.mock(ReactiveSocket.class);
        ReactiveSocket three = Mockito.mock(ReactiveSocket.class);

        InetSocketAddress address1 = InetSocketAddress.createUnresolved("one", 8888);
        InetSocketAddress address2 = InetSocketAddress.createUnresolved("two", 8888);
        InetSocketAddress address3 = InetSocketAddress.createUnresolved("three", 8888);

        ReactiveSocketLoadBalancer.ReactiveSocketFactory reactiveSocketFactory
            = Mockito.mock(ReactiveSocketLoadBalancer.ReactiveSocketFactory.class);

        Mockito.when(reactiveSocketFactory.call(address1)).thenReturn(one);
        Mockito.when(reactiveSocketFactory.call(address2)).thenReturn(two);
        Mockito.when(reactiveSocketFactory.call(address3)).thenReturn(three);

        ReactiveSocketLoadBalancer.StaticListFactory socketAddressFactory
            = ReactiveSocketLoadBalancer
            .StaticListFactory
            .newInstance(address1, address2, address3);

        ReactiveSocketLoadBalancer reactiveSocketLoadBalancer
            = new ReactiveSocketLoadBalancer(
            socketAddressFactory,
            ReactiveSocketLoadBalancer.NO_CHANGE_PROVIDER,
            reactiveSocketFactory,
            ReactiveSocketLoadBalancer.LEAST_LOADED_SELECTOR
        );

        TestSubscriber testSubscriber = new TestSubscriber();

        Observable
            .range(0, 100_000)
            .doOnNext(i -> {
                ReactiveSocketStatsHolder sh = reactiveSocketLoadBalancer
                    .nextAvailableSocket()
                    .toBlocking().last();

                long l = sh.recordStart();
                sh.recordSuccess(l);
            })
            .subscribe(testSubscriber);

        testSubscriber.awaitTerminalEvent(5, TimeUnit.SECONDS);
        testSubscriber.assertNoErrors();
        testSubscriber.assertCompleted();

        reactiveSocketLoadBalancer
            .reactiveSocketStatsHolders
            .values()
            .forEach(reactiveSocketStatsHolder -> {
                System.out.println(reactiveSocketStatsHolder.toString());
                Assert.assertEquals(0, reactiveSocketStatsHolder.outstandingRequests.get());
            });
    }


}