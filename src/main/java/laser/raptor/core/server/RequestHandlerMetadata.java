package laser.raptor.core.server;

import rx.Observable;

import java.util.function.Function;

class RequestHandlerMetadata {
    final int methodId;
    final String serviceClassName;
    final Class<?> requestClass;
    final Class<?> responseClass;
    final Function<Object, Observable> handler;

    public RequestHandlerMetadata(int methodId, String serviceClassName, Class<?> requestClass, Class<?> responseClass, Function<Object, Observable> handler) {
        this.methodId = methodId;
        this.serviceClassName = serviceClassName;
        this.requestClass = requestClass;
        this.responseClass = responseClass;
        this.handler = handler;
    }

    public int getMethodId() {
        return methodId;
    }

    public String getServiceClassName() {
        return serviceClassName;
    }

    public Class<?> getRequestClass() {
        return requestClass;
    }

    public Class<?> getResponseClass() {
        return responseClass;
    }

    public Function<Object, Observable> getHandler() {
        return handler;
    }
}
