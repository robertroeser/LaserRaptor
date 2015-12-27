package laser.raptor.core.client;

public class LaserRaptorClientServiceFactoryTest {/*
    @Test
    public void testGetByClass() {
        E0 e0 = new E0();
        E1 e1 = new E1();
        E1 e11 = new E1();
        E2 e2 = new E2();

        Map<Class<? extends LaserRaptorClientService>, Map<String, LaserRaptorClientService>> clientServices
                = LaserRaptorClientServiceFactory.INSTANCE.clientServices;

        Map<String, LaserRaptorClientService> e0map = new ConcurrentHashMap<>();
        Map<String, LaserRaptorClientService> e1map = new ConcurrentHashMap<>();
        Map<String, LaserRaptorClientService> e2map = new ConcurrentHashMap<>();

        clientServices.put(E0.class, e0map);
        clientServices.put(E1.class, e1map);
        clientServices.put(E2.class, e2map);

        e0map.put("localhost", e0);
        e1map.put("localhost", e1);
        e1map.put("somewhere", e11);
        e2map.put("somewhere", e2);

        E0 e0e = LaserRaptorClientServiceFactory.getLaserRaptorService(E0.class, new Resolver() {
            @Override
            public String host() {
                return "localhost";
            }

            @Override
            public int port() {
                return 0;
            }
        });

        Assert.assertEquals(e0, e0e);

        E1 e1e = LaserRaptorClientServiceFactory.getLaserRaptorService(E1.class, new Resolver() {
            @Override
            public String host() {
                return "localhost";
            }

            @Override
            public int port() {
                return 0;
            }
        });

        Assert.assertEquals(e1, e1e);

        E1 e11e = LaserRaptorClientServiceFactory.getLaserRaptorService(E1.class, new Resolver() {
            @Override
            public String host() {
                return "somewhere";
            }

            @Override
            public int port() {
                return 0;
            }
        });

        Assert.assertEquals(e11, e11e);

        E2 e2e = LaserRaptorClientServiceFactory.getLaserRaptorService(E2.class, new Resolver() {
            @Override
            public String host() {
                return "somewhere";
            }

            @Override
            public int port() {
                return 0;
            }
        });

        Assert.assertEquals(e2, e2e);
    }

    public static class E0 extends LaserRaptorClientService {
        E0() {}

        public E0(String host, int port) {
            super(host, port);
        }
    }

    class E1 extends LaserRaptorClientService {
        E1() {}

        public E1(String host, int port) {
            super(host, port);
        }
    }

    class E2 extends LaserRaptorClientService {
        E2() {}

        public E2(String host, int port) {
            super(host, port);
        }
    }*/
}