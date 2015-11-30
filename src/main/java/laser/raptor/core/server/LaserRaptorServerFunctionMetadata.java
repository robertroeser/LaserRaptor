package laser.raptor.core.server;

import rx.Observable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Function;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LaserRaptorServerFunctionMetadata {
    long hash();
    int serviceId();
    int methodId();
    Class<Function<Object, Observable>> serviceClassName();
    Class<?> requestClass();
    Class<?> responseClass();
}
