package laser.raptor.core;

import laser.raptor.core.server.server_functions.FireAndForgetServerFunction;
import laser.raptor.core.server.server_functions.RequestNServerFunction;
import laser.raptor.core.server.server_functions.RequestResponseServerFunction;
import laser.raptor.core.server.server_functions.ServerFunction;
import laser.raptor.core.server.server_functions.SubscribeServiceFunction;

/**
 * ReactiveSocket Interaction Models
 */
public enum InteractionModel {
    REQUEST_RESPONSE(RequestResponseServerFunction.class, "requestResponse"),
    REQUEST_STREAM(RequestNServerFunction.class, "requestStream"),
    SUBSCRIPTION(SubscribeServiceFunction.class, "subscription"),
    FIRE_AND_FORGET(FireAndForgetServerFunction.class, "fireAndForget"),
    CHANNEL(ServerFunction.class, "channel"),
    METADATA_PUSH(ServerFunction.class, "metadataPush");

    private Class<? extends ServerFunction> functionType;

    private String methodTemplateName;

    InteractionModel(Class<? extends ServerFunction> functionType, String methodTemplateName) {
        this.functionType = functionType;
        this.methodTemplateName = methodTemplateName;
    }

    public Class<? extends ServerFunction> getFunctionType() {
        return functionType;
    }

    public String getMethodTemplateName() {
        return methodTemplateName;
    }
}
