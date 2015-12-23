package laser.raptor.test1;

import laser.raptor.core.server.LaserRaptorServerFunctionMetadata;
import laser.raptor.core.server.server_functions.FireAndForgetServerFunction;
import rx.Observable;

@LaserRaptorServerFunctionMetadata(
        hash = 8589934692L,
        methodId = 2,
        requestClass = Func1Request.class,
        responseClass = Void.class,
        serviceClass = Func4.class,
        serviceId = 100)
public class Func4 implements FireAndForgetServerFunction<Func1Request> {
    @Override
    public Observable<Void> apply(Observable<Func1Request> observable) {
        return Observable.empty();
    }
}
