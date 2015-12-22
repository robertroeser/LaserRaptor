package laser.raptor.test2;

import laser.raptor.core.server.LaserRaptorServerFunctionMetadata;
import laser.raptor.core.server.server_functions.ServerFunction;
import rx.Observable;

@LaserRaptorServerFunctionMetadata(
        hash =  2,
        methodId = 1,
        requestClass = Object.class,
        responseClass = Object.class,
        serviceClass = Func2.class,
        serviceId = 200)
public class Func2 implements ServerFunction {
    @Override
    public Observable apply(Observable observable) {
        return null;
    }

}
