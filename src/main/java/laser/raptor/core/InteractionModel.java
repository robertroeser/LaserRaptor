package laser.raptor.core;

import laser.raptor.core.server.server_functions.FireAndForgetServerFunction;
import laser.raptor.core.server.server_functions.RequestNServerFunction;
import laser.raptor.core.server.server_functions.RequestResponseServerFunction;
import laser.raptor.core.server.server_functions.ServerFunction;
import laser.raptor.core.server.server_functions.SubscribeServerFunction;

/**
 * ReactiveSocket Interaction Models
 */
public enum InteractionModel {
    REQUEST_RESPONSE(RequestResponseServerFunction.class, "requestResponse"),
    REQUEST_STREAM(RequestNServerFunction.class, "requestStream"),
    SUBSCRIPTION(SubscribeServerFunction.class, "subscription"),
    FIRE_AND_FORGET(FireAndForgetServerFunction.class, "fireAndForget"),
    CHANNEL(ServerFunction.class, "channel"),
    METADATA_PUSH(ServerFunction.class, "metadataPush");

    private Class<? extends ServerFunction> functionType;

    private String interactionModelTemplateName;

    InteractionModel(Class<? extends ServerFunction> functionType, String interactionModelTemplateName) {
        this.functionType = functionType;
        this.interactionModelTemplateName = interactionModelTemplateName;
    }

    public Class<? extends ServerFunction> getFunctionType() {
        return functionType;
    }

    public String getInteractionModelTemplateName() {
        return interactionModelTemplateName;
    }
}
