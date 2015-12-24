package laser.raptor.test1;

import laser.raptor.core.server.LaserRaptorServerFunctionMetadata;
import laser.raptor.core.server.server_functions.RequestResponseServerFunction;
import rx.Observable;

@LaserRaptorServerFunctionMetadata(
    hash =  1288490189100L,
    methodId = 300,
    requestClass = Integer.class,
    responseClass = Integer.class,
    serviceClass = FuncPrimitive.class,
    serviceId = 300)
public class FuncPrimitive implements RequestResponseServerFunction<Integer, Integer> {
    @Override
    public Observable<Integer> apply(Observable<Integer> func1RequestObservable) {
        return func1RequestObservable.map(i -> i + 1);
    }
}