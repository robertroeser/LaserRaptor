package laser.raptor.ext.client;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import laser.raptor.core.client.ReactiveSocketLoadBalancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rroeser on 1/4/16.
 */
public class EurekaSocketAddressFactory implements ReactiveSocketLoadBalancer.SocketAddressFactory {
    private static final long TIMEOUT = TimeUnit.SECONDS.toNanos(15);

    private static final Logger logger = LoggerFactory.getLogger(EurekaSocketAddressFactory.class);

    final private DiscoveryClient client;

    final List<SocketAddress> pool;

    final List<SocketAddress> prunedList;

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
        this.pool = new CopyOnWriteArrayList<>();
        this.prunedList = new CopyOnWriteArrayList<>();
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
            .just(pool)
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

    /**
     * Gets an implementation of the {@link laser.raptor.core.client.ReactiveSocketLoadBalancer.ClosedConnectionsProvider}
     * that can be provided to the {@link ReactiveSocketLoadBalancer} to clean up missing connections
     * @return an Observable of list connections that should be closed
     */
    public ReactiveSocketLoadBalancer.ClosedConnectionsProvider getClosedConnectionProvider() {
        return () -> Observable.just(prunedList).finallyDo(prunedList::clear);
    }

    void pruneList(List<InstanceInfo> instancesByVipAddress) {
        List<InetSocketAddress> currentPrunedList = new ArrayList<>(pool.size());
        pool
            .forEach(socketAddress -> {
                InetSocketAddress address = (InetSocketAddress) socketAddress;

                boolean found = false;
                for (InstanceInfo instanceInfo : instancesByVipAddress) {
                    InetSocketAddress current = instanceInfoToSocketAddress(instanceInfo);
                    found = current.equals(address);

                    if (found) {
                        break;
                    }
                }

                if (!found) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Removing socket {}", address);
                    }

                    currentPrunedList.add(address);
                }

            });

        if (!currentPrunedList.isEmpty()) {
            prunedList.addAll(currentPrunedList);
            pool.removeAll(currentPrunedList);
        }
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
                if (logger.isDebugEnabled()) {
                    logger.debug("Address {} not found in pool - adding", address);
                }

                pool.add(address);
                count++;
            }
        }
    }
}
