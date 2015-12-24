package laser.raptor.core.client;

import uk.co.real_logic.agrona.LangUtil;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class LaserRaptorClientServiceFactory {
    final static LaserRaptorClientServiceFactory INSTANCE = new LaserRaptorClientServiceFactory();

    final Map<Class<? extends LaserRaptorClientService>, Map<String, LaserRaptorClientService>> clientServices =
            new ConcurrentHashMap<>();

    private LaserRaptorClientServiceFactory() {}

    @SuppressWarnings("unchecked")
    public static <T extends LaserRaptorClientService> T getLaserRaptorService(
            Class<T> clazz,
            Resolver resolver) {

        Map<String, LaserRaptorClientService> hostToService = INSTANCE.clientServices.computeIfAbsent(clazz, c -> new ConcurrentHashMap<>());

        LaserRaptorClientService service = hostToService.computeIfAbsent(resolver.host(), h -> {
            LaserRaptorClientService s = null;

            try {
                Constructor<?>[] constructors = clazz.getDeclaredConstructors();
                Arrays.asList(constructors).forEach(c -> {
                    System.out.println(c.toGenericString());
                });
                Constructor<? extends LaserRaptorClientService> constructor = clazz.getDeclaredConstructor(String.class, int.class);
                constructor.setAccessible(true);
                s = constructor.newInstance(resolver.host(), resolver.port());
            } catch (Exception e) {
                LangUtil.rethrowUnchecked(e);
            }

            return s;
        });

        return (T) service;
    }


}
