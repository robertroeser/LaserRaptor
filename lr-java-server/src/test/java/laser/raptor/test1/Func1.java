package laser.raptor.test1;

import laser.raptor.core.server.LaserRaptorServerFunctionMetadata;
import laser.raptor.core.server.server_functions.RequestResponseServerFunction;
import rx.Observable;

@LaserRaptorServerFunctionMetadata(
        hash =  4294967396L,
        serviceName =  "TestService",
        methodName =  "foo",
        methodId = 1,
        requestClass = Func1Request.class,
        responseClass = Func1Reply.class,
        serviceClass = Func1.class,
        serviceId = 100)
public class Func1 implements RequestResponseServerFunction<Func1Request, Func1Reply> {
    @Override
    public Observable<Func1Reply> apply(Observable<Func1Request> func1RequestObservable) {
        return func1RequestObservable
                .map(func1Request -> {
                    Func1Reply reply = new Func1Reply();
                    reply.setaString("hello " + func1Request);
                    return reply;
                });
    }
}
