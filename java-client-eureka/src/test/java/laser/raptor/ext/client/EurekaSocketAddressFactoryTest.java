package laser.raptor.ext.client;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EurekaSocketAddressFactoryTest {
    @Test
    public void testFoundValueWithPoolSmallerThan8() {
        testFoundValue(5, 20);
    }

    @Test
    public void testFoundValueWithPoolSizeSmallerThan8() {
        testFoundValue(5, 5);
    }

    @Test
    public void testFoundValueWithPoolEqualTo8() {
        testFoundValue(8, 8);
    }

    @Test
    public void testFoundValueWithPoolGreaterThan8() {
        testFoundValue(100, 200);
    }

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

        ArrayList<SocketAddress> pool = eurekaSocketAddressFactory.pool;

        Assert.assertFalse(pool.isEmpty());
        Assert.assertEquals(expectedSize, pool.size());

        pool.forEach(System.out::println);

        int oldSize = pool.size();

        Collections.shuffle(instanceInfos);
        instanceInfos.remove(0);
        instanceInfos.remove(0);
        instanceInfos.remove(0);

        eurekaSocketAddressFactory.pruneList(instanceInfos);

        Assert.assertEquals(oldSize - 3, pool.size());
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

        ArrayList<SocketAddress> pool = eurekaSocketAddressFactory.pool;

        Assert.assertFalse(pool.isEmpty());
        Assert.assertEquals(expectedSize, pool.size());

        pool.forEach(System.out::println);

        return instanceInfos;
    }

    public void testFoundValue(int size, int poolSize) {

        int bufferSize = (size < 8 || poolSize < 8) ? 8 : size;

        ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
        for (int i = 0; i < size; i++) {
            byteBuffer.put((byte) 1);
        }

        long expected = byteBuffer.getLong(0);
        System.out.println("expected => " + expected);

        DiscoveryClient client = Mockito.mock(DiscoveryClient.class);
        EurekaSocketAddressFactory eurekaSocketAddressFactory = new EurekaSocketAddressFactory(client, "localhost", false, poolSize);

        for (int i = 0; i < size; i++) {
            eurekaSocketAddressFactory.pool.add(Mockito.mock(SocketAddress.class));
        }

        long foundValue = eurekaSocketAddressFactory.foundValue();
        System.out.println("found    => " + foundValue);

        Assert.assertEquals(foundValue, expected);
    }
}