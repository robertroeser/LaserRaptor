package laser.raptor.core.server;

import laser.raptor.core.server.server_functions.ServerFunction;
import rx.Observable;

class RequestHandlerMetadata {
    final int methodId;
    final String serviceClassName;
    final Class<?> requestClass;
    final Class<?> responseClass;
    final ServerFunction<Observable, Observable> handler;

    public RequestHandlerMetadata(int methodId, String serviceClassName, Class<?> requestClass, Class<?> responseClass, ServerFunction<Observable, Observable> handler) {
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

    public ServerFunction<Observable, Observable> getHandler() {
        return handler;
    }
}
