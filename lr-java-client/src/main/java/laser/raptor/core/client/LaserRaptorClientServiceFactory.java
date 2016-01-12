package laser.raptor.core.client;

import uk.co.real_logic.agrona.LangUtil;

import java.lang.reflect.Constructor;

public final class LaserRaptorClientServiceFactory {
    final static LaserRaptorClientServiceFactory INSTANCE = new LaserRaptorClientServiceFactory();

    private LaserRaptorClientServiceFactory() {
    }

    @SuppressWarnings("unchecked")
    public static <T extends LaserRaptorClientService> T getLaserRaptorService(
        Class<T> clazz,
        ReactiveSocketLoadBalancer.SocketAddressFactory socketAddressFactory,
        ReactiveSocketLoadBalancer.ClosedConnectionsProvider closedConnectionsProvider,
        ReactiveSocketLoadBalancer.ReactiveSocketFactory reactiveSocketFactory,
        ReactiveSocketLoadBalancer.StatsSelector statsSelector) {

        ReactiveSocketLoadBalancer loadBalancer = new ReactiveSocketLoadBalancer(
            socketAddressFactory,
            closedConnectionsProvider,
            reactiveSocketFactory,
            statsSelector);

        LaserRaptorClientService s = null;

        try {
            Constructor<? extends LaserRaptorClientService> constructor = clazz.getDeclaredConstructor(ReactiveSocketLoadBalancer.class);
            constructor.setAccessible(true);
            s = constructor.newInstance(loadBalancer);
        } catch (Exception e) {
            LangUtil.rethrowUnchecked(e);
        }

        return (T) s;
    }


}
