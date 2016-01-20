package laser.raptor.laser.raptor.antlr;

import laser.raptor.antlr.generated.LaserRaptorBaseListener;
import laser.raptor.antlr.generated.LaserRaptorParser;
import laser.raptor.core.InteractionModel;
import laser.raptor.string_template.java.ClientServiceTemplate;
import laser.raptor.string_template.java.GuiceModuleTemplate;
import laser.raptor.string_template.java.MessageTemplate;
import laser.raptor.string_template.java.ServerServiceTemplate;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static laser.raptor.string_template.Util.reservedWord;
import static laser.raptor.string_template.Util.uncapitalize;

public class LaserRaptorListener extends LaserRaptorBaseListener {
    private String packageName;

    private String currentServiceName = null;

    private ClientServiceTemplate currentClientServiceTemplate;

    private ServerServiceTemplate currentServerServiceTemplate;

    private MessageTemplate currentMessageTemplate = null;

    private Set<String> serviceFunctionNames;

    private Map<String, MessageTemplate> messageTemplates;

    private Map<String, ClientServiceTemplate> clientServiceTemplates;

    private Map<String, ServerServiceTemplate> serverServiceTemplates;

    private GuiceModuleTemplate guiceModuleTemplate;
    private boolean guice;

    public LaserRaptorListener(boolean guice) {
        messageTemplates = new HashMap<>();
        serviceFunctionNames = new HashSet<>();
        clientServiceTemplates = new HashMap<>();
        serverServiceTemplates = new HashMap<>();

        this.guice = guice;
    }

    @Override
    public void enterNamespaceDeclaration(@NotNull LaserRaptorParser.NamespaceDeclarationContext ctx) {
        ParseTree child = ctx.getChild(1);
        packageName = child.getText();
    }

    @Override
    public void enterMessageDeclaration(@NotNull LaserRaptorParser.MessageDeclarationContext ctx) {
        ParseTree child = ctx.getChild(1);
        String messageName = child.getText();

        if (reservedWord(messageName)) {
            throw new InvalidMessageNameException("Can not name a message with a reserved word => " + messageName);
        }

        MessageTemplate newMessageTemplate = MessageTemplate.newMessageTemplate();
        newMessageTemplate.className(messageName);
        newMessageTemplate.packageName(packageName);
        messageTemplates.put(messageName, newMessageTemplate);

        if (currentMessageTemplate != null) {
            String uncapitalize = uncapitalize(newMessageTemplate.getClassName());

            if (reservedWord(uncapitalize)) {
                throw new InvalidFieldNameException("Can not name a field with a reserved word => " + uncapitalize);
            }

            currentMessageTemplate
                    .addField(
                            newMessageTemplate.getClassName(),
                            uncapitalize);
        }

        currentMessageTemplate = newMessageTemplate;
    }

    @Override
    public void exitMessageDeclaration(@NotNull LaserRaptorParser.MessageDeclarationContext ctx) {
        if (currentMessageTemplate != null) {
            currentMessageTemplate = messageTemplates.get(currentMessageTemplate.getClassName());
        }
    }

    @Override
    public void enterFieldDeclaration(@NotNull LaserRaptorParser.FieldDeclarationContext ctx) {
        ParseTree type = ctx.getChild(0);
        ParseTree fieldName = ctx.getChild(1);

        String text = type.getText().toUpperCase();

        MessageTemplate.MessageFieldTypes messageFieldType = MessageTemplate.MessageFieldTypes.valueOf(text);

        String fieldNameText = fieldName.getText();

        if (reservedWord(fieldNameText)) {
            throw new IllegalStateException("Can not name field with a reserved word => " + fieldNameText);
        }

        currentMessageTemplate
                .addField(messageFieldType, fieldNameText);
    }

    @Override
    public void enterServiceDeclaration(@NotNull LaserRaptorParser.ServiceDeclarationContext ctx) {
        ParseTree serviceName = ctx.getChild(1);
        String text = serviceName.getText();

        if (reservedWord(text)) {
            throw new IllegalStateException("Can not name service with a reserved word => " + text);
        }

        currentServiceName = text;

        currentClientServiceTemplate = ClientServiceTemplate.newClientServiceTemplate();
        currentClientServiceTemplate.className(text);
        currentClientServiceTemplate.packageName(packageName);
        clientServiceTemplates.put(currentServiceName, currentClientServiceTemplate);

        currentServerServiceTemplate = ServerServiceTemplate.newServerServiceTemplate(guice);
        currentServerServiceTemplate.className(text);
        currentServerServiceTemplate.packageName(packageName);
        serverServiceTemplates.put(currentServiceName, currentServerServiceTemplate);

    }

    @Override
    public void enterServiceBodyDeclaration(@NotNull LaserRaptorParser.ServiceBodyDeclarationContext ctx) {
        ParseTree interactionModel = ctx.getChild(0);
        ParseTree serviceFunctionName = ctx.getChild(1);
        ParseTree requestType = ctx.getChild(2);
        ParseTree responseType = ctx.getChild(4);

        String text = serviceFunctionName.getText();

        if (serviceFunctionNames.contains(text)) {
            throw new DuplicateServiceFunctionException("A function with the name " + text + " already exists");
        } else {
            serviceFunctionNames.add(text);
        }

        String interactionModelText = interactionModel.getText();

        ClientServiceTemplate.MethodModel methodModel =
            new ClientServiceTemplate.MethodModel(InteractionModel.findByInteractionModelTemplateName(interactionModelText),
                requestType.getText(),
                responseType == null ? "Void" : responseType.getText(),
                text,
                currentServiceName.hashCode(),
                text.hashCode());

        currentClientServiceTemplate.addMethod(methodModel);

        ServerServiceTemplate.ServerServiceModel serverServiceModel =
            new ServerServiceTemplate.ServerServiceModel(InteractionModel.findByInteractionModelTemplateName(interactionModelText),
                currentServiceName,
                requestType.getText(),
                responseType == null ? "Void" : responseType.getText(),
                text,
                currentServiceName.hashCode(),
                text.hashCode());

        currentServerServiceTemplate.addServerService(serverServiceModel);

        if (guice) {
            if (guiceModuleTemplate == null) {
                guiceModuleTemplate = GuiceModuleTemplate
                    .newGuiceModuleTemplate()
                    .packageName(packageName);
            }

            guiceModuleTemplate.addClassToBind(currentServiceName + "_" + text);
        }
    }

    public Map<String, ServerServiceTemplate> getServerServiceTemplates() {
        return serverServiceTemplates;
    }

    public Map<String, MessageTemplate> getMessageTemplates() {
        return messageTemplates;
    }

    public Map<String, ClientServiceTemplate> getClientServiceTemplates() {
        return clientServiceTemplates;
    }

    public GuiceModuleTemplate getGuiceModuleTemplate() {
        return guiceModuleTemplate;
    }
}
