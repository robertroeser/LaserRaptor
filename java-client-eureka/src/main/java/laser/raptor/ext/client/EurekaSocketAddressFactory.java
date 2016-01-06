package laser.raptor.ext.client;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import laser.raptor.core.client.ReactiveSocketLoadBalancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rroeser on 1/4/16.
 */
public class EurekaSocketAddressFactory implements ReactiveSocketLoadBalancer.SocketAddressFactory {
    private static final long TIMEOUT = TimeUnit.SECONDS.toNanos(15);

    private static final Logger logger = LoggerFactory.getLogger(EurekaSocketAddressFactory.class);

    final private DiscoveryClient client;

    final ArrayList<SocketAddress> pool;

    final private int poolSize;

    final private String vip;

    final private boolean secure;

    final ReentrantLock reentrantLock;

    volatile long lastUpdate = 0;
    long p1,p2,p3,p4,p5,p6;

    public EurekaSocketAddressFactory(DiscoveryClient client, String vip) {
        this(client, vip, false, 8);
    }

    public EurekaSocketAddressFactory(DiscoveryClient client, String vip, boolean secure, int poolSize) {
        this.client = client;
        this.poolSize = poolSize;
        this.vip = vip;
        this.secure = secure;
        this.pool = new ArrayList<>();
        this.reentrantLock = new ReentrantLock();
    }

    @Override
    public Observable<List<SocketAddress>> call() {
        if (pool.isEmpty()) {
            synchronized (this) {
                if (pool.isEmpty()) {
                    List<InstanceInfo> instancesByVipAddress = client.getInstancesByVipAddress(vip, secure);
                    populateList(instancesByVipAddress);
                    lastUpdate = System.nanoTime();
                }
            }
        }

        return Observable
            .<List<SocketAddress>>just(pool)
            .finallyDo(() -> {
                if (System.nanoTime() - lastUpdate > TIMEOUT) {
                    try {
                        if (reentrantLock.tryLock()) {
                            List<InstanceInfo> instancesByVipAddress = client.getInstancesByVipAddress(vip, secure);
                            pruneList(instancesByVipAddress);
                            populateList(instancesByVipAddress);
                            lastUpdate = System.nanoTime();
                        }
                    } finally {
                        if (reentrantLock.isHeldByCurrentThread()) {
                            reentrantLock.unlock();
                        }
                    }
                }
            });
    }

    long foundValue() {
        int size = pool.size();
        int bufferSize = (pool.size() < 8 || poolSize < 8) ? 8 : pool.size();

        ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize);
        for (int i = 0; i < size; i++) {
            byteBuffer.put((byte) 1);
        }

        return byteBuffer.getLong(0);
    }

    void pruneList(List<InstanceInfo> instancesByVipAddress) {
        final long foundValue = foundValue();
        ByteBuffer buffer = ByteBuffer.allocate(pool.size());

        for (InstanceInfo instanceInfo : instancesByVipAddress) {
            InetSocketAddress address = instanceInfoToSocketAddress(instanceInfo);
            int index = pool.indexOf(address);

            if (index > -1) {
                if (logger.isDebugEnabled()) {
                    logger.debug("removing socket {}", pool.get(index));
                }

                buffer.put(index, (byte) 1);
            }

            if (buffer.getLong(0) == foundValue) {
                break;
            }
        }

        List<SocketAddress> removed = new ArrayList<>();
        for (int i = 0; i < buffer.capacity(); i++) {
            if (buffer.get(i) == 1) {
                SocketAddress socketAddress = pool.get(i);
                removed.add(socketAddress);
            }
        }

        removed.forEach(pool::remove);
    }

    InetSocketAddress instanceInfoToSocketAddress(InstanceInfo instanceInfo) {
        return
            secure
                ? InetSocketAddress.createUnresolved(instanceInfo.getIPAddr(), instanceInfo.getSecurePort())
                : InetSocketAddress.createUnresolved(instanceInfo.getIPAddr(), instanceInfo.getPort());
    }

    void populateList(List<InstanceInfo> instancesByVipAddress) {
        final int numOfInstances = instancesByVipAddress.size();
        final int limit = poolSize - pool.size();
        int count = 0;

        while (count < limit && count < numOfInstances) {
            InstanceInfo instanceInfo = instancesByVipAddress.get(count);
            InetSocketAddress address = instanceInfoToSocketAddress(instanceInfo);
            if (!pool.contains(address)) {
                pool.add(address);
                count++;
            }
        }
    }
}
