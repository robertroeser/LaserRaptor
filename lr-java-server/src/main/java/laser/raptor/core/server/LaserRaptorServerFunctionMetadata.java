package laser.raptor.core.server;

import laser.raptor.core.server.server_functions.ServerFunction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface LaserRaptorServerFunctionMetadata {
    long hash();
    int serviceId();
    int methodId();
    String serviceName();
    String methodName();
    Class<? extends ServerFunction> serviceClass();
    Class<?> requestClass();
    Class<?> responseClass();
}
