package laser.raptor.test1.test3;

import laser.raptor.core.server.LaserRaptorServerFunctionMetadata;
import laser.raptor.core.server.server_functions.ServerFunction;
import rx.Observable;

@LaserRaptorServerFunctionMetadata(
    hash = 3,
    methodId = 1,
    serviceName = "TestService",
    methodName = "foo",
    requestClass = Object.class,
    responseClass = Object.class,
    serviceClass = Func3.class,
    serviceId = 300)
public class Func3 implements ServerFunction {
    @Override
    public Observable apply(Observable observable) {
        return null;
    }
}
