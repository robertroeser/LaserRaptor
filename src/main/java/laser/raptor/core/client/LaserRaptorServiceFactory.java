package laser.raptor.core.client;

import uk.co.real_logic.agrona.LangUtil;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LaserRaptorServiceFactory {
    private LaserRaptorServiceFactory() {}

    private static Map<String, LaserRaptorClientService> reactiveSockets = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends LaserRaptorClientService> T getLaserRaptorService(Class<T> clazz, Resolver resolver) {
        return (T) reactiveSockets
                .computeIfAbsent(resolver.host(), h -> {
                    T t = null;

                    try {
                        Constructor<T> constructor = clazz.getConstructor(String.class, Integer.class);
                        t = constructor.newInstance(resolver.host(), resolver.port());
                    } catch (Exception e) {
                        LangUtil.rethrowUnchecked(e);
                    }

                    return t;
                });
    }
}
