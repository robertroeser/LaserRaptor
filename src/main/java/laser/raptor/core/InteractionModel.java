package laser.raptor.core;

import laser.raptor.core.server.server_functions.FireAndForgetServerFunction;
import laser.raptor.core.server.server_functions.RequestNServerFunction;
import laser.raptor.core.server.server_functions.RequestResponseServerFunction;
import laser.raptor.core.server.server_functions.ServerFunction;
import laser.raptor.core.server.server_functions.SubscribeServerFunction;

import java.util.Arrays;

/**
 * ReactiveSocket Interaction Models
 */
public enum InteractionModel {
    REQUEST_RESPONSE(RequestResponseServerFunction.class, "request"),
    REQUEST_STREAM(RequestNServerFunction.class, "requestN"),
    SUBSCRIPTION(SubscribeServerFunction.class, "subscription"),
    FIRE_AND_FORGET(FireAndForgetServerFunction.class, "fire"),
    CHANNEL(ServerFunction.class, "channel"),
    METADATA_PUSH(ServerFunction.class, "metadataPush");

    private Class<? extends ServerFunction> functionType;

    private String interactionModelTemplateName;

    InteractionModel(Class<? extends ServerFunction> functionType, String interactionModelTemplateName) {
        this.functionType = functionType;
        this.interactionModelTemplateName = interactionModelTemplateName;
    }

    public static InteractionModel findByInteractionModelTemplateName(String name) {
        return Arrays
            .asList(InteractionModel.values())
            .stream()
            .filter(i -> i.getInteractionModelTemplateName().equalsIgnoreCase(name))
            .findFirst()
            .get();
    }

    public Class<? extends ServerFunction> getFunctionType() {
        return functionType;
    }

    public String getInteractionModelTemplateName() {
        return interactionModelTemplateName;
    }
}
