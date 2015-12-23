package laser.raptor.core.server;

import laser.raptor.core.server.server_functions.ServerFunction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LaserRaptorServerFunctionMetadata {
    long hash();
    int serviceId();
    int methodId();
    Class<? extends ServerFunction> serviceClass();
    Class<?> requestClass();
    Class<?> responseClass();
}
