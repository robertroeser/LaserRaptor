package laser.raptor.ext.client;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

public class EurekaSocketAddressFactoryTest {
    @Test
    public void testPopulateEmptyPool() {
        testPopulateEmptyPool(8, 8, 8);
    }

    @Test
    public void testPopulateEmptyPoolWithPoolSizeLessThanNumInstanceInfos() {
        testPopulateEmptyPool(8, 20, 8);
    }

    @Test
    public void testPopulateEmptyPoolWithPoolSizeGreaterThanNumInstanceInfos() {
        testPopulateEmptyPool(20, 5, 5);
    }

    @Test
    public void testPopulateEmptyPooWithSizesGreaterThen8() {
        testPopulateEmptyPool(45, 150, 45);
    }

    @Test
    public void testPrune() {
        int poolSize = 10;
        int numInstanceInfo = 20;
        int expectedSize = 10;

        DiscoveryClient client = Mockito.mock(DiscoveryClient.class);
        EurekaSocketAddressFactory eurekaSocketAddressFactory = new EurekaSocketAddressFactory(client, "test", false, poolSize);

        List<InstanceInfo> instanceInfos = new ArrayList<>();

        for (int i = 0; i < numInstanceInfo; i++) {
            InstanceInfo instanceInfo = Mockito.mock(InstanceInfo.class);
            Mockito.when(instanceInfo.getIPAddr()).thenReturn("192.168.1." + i);
            Mockito.when(instanceInfo.getPort()).thenReturn(7001);
            instanceInfos.add(instanceInfo);
        }

        eurekaSocketAddressFactory.populateList(instanceInfos);

        List<SocketAddress> pool = eurekaSocketAddressFactory.pool;

        Assert.assertFalse(pool.isEmpty());
        Assert.assertEquals(expectedSize, pool.size());

        pool.forEach(System.out::println);

        int oldSize = pool.size();

        instanceInfos.remove(0);
        instanceInfos.remove(0);
        instanceInfos.remove(0);

        eurekaSocketAddressFactory.pruneList(instanceInfos);

        Assert.assertEquals(oldSize - 3, pool.size());

        Observable<List<SocketAddress>> call = eurekaSocketAddressFactory.getClosedConnectionProvider().call();

        TestSubscriber subscriber = new TestSubscriber();
        call
            .doOnNext(socketAddresses -> Assert.assertEquals(3, socketAddresses.size()))
            .doOnError(Throwable::printStackTrace)
            .subscribe(subscriber);

        subscriber.assertNoErrors();
        subscriber.assertCompleted();
    }

    public List<InstanceInfo> testPopulateEmptyPool(int poolSize, int numInstanceInfo, int expectedSize) {
        DiscoveryClient client = Mockito.mock(DiscoveryClient.class);
        EurekaSocketAddressFactory eurekaSocketAddressFactory = new EurekaSocketAddressFactory(client, "test", false, poolSize);

        List<InstanceInfo> instanceInfos = new ArrayList<>();

        for (int i = 0; i < numInstanceInfo; i++) {
            InstanceInfo instanceInfo = Mockito.mock(InstanceInfo.class);
            Mockito.when(instanceInfo.getIPAddr()).thenReturn("192.168.1." + i);
            Mockito.when(instanceInfo.getPort()).thenReturn(7001);
            instanceInfos.add(instanceInfo);
        }

        //Mockito.when(client.getInstancesByVipAddress(Mockito.anyString(), Mockito.anyBoolean())).thenReturn(instanceInfos);

        eurekaSocketAddressFactory.populateList(instanceInfos);

        List<SocketAddress> pool = eurekaSocketAddressFactory.pool;

        Assert.assertFalse(pool.isEmpty());
        Assert.assertEquals(expectedSize, pool.size());

        pool.forEach(System.out::println);

        return instanceInfos;
    }

    @Test
    public void testCall() {
        int poolSize = 10;
        int numInstanceInfo = 20;
        int expectedSize = 10;

        DiscoveryClient client = Mockito.mock(DiscoveryClient.class);
        EurekaSocketAddressFactory eurekaSocketAddressFactory = new EurekaSocketAddressFactory(client, "test", false, poolSize);

        List<InstanceInfo> instanceInfos = new ArrayList<>();

        for (int i = 0; i < numInstanceInfo; i++) {
            InstanceInfo instanceInfo = Mockito.mock(InstanceInfo.class);
            Mockito.when(instanceInfo.getIPAddr()).thenReturn("192.168.1." + i);
            Mockito.when(instanceInfo.getPort()).thenReturn(7001);
            instanceInfos.add(instanceInfo);
        }

        Mockito.when(client.getInstancesByVipAddress(Mockito.anyString(), Mockito.anyBoolean())).thenReturn(instanceInfos);

        TestSubscriber subscriber = new TestSubscriber();
        eurekaSocketAddressFactory
            .call()
            .doOnNext(socketAddresses -> Assert.assertEquals(expectedSize, socketAddresses.size()))
            .doOnError(Throwable::printStackTrace)
            .subscribe(subscriber);
        subscriber.awaitTerminalEvent();
        subscriber.assertNoErrors();
    }
}