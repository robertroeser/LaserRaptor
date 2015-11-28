package laser.raptor.laser.raptor.antlr;

import laser.raptor.antlr.generated.LaserRaptorBaseListener;
import laser.raptor.antlr.generated.LaserRaptorParser;
import laser.raptor.string_template.java.MessageTemplate;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;

import static laser.raptor.string_template.Util.uncapitalize;
import static laser.raptor.string_template.Util.reservedWord;

/**
 * Created by rroeser on 11/26/15.
 */
public class LaserRaptorListener extends LaserRaptorBaseListener {
    private String packageName;

    private MessageTemplate currentTemplate = null;

    private Map<String, MessageTemplate> messageTemplates;

    public LaserRaptorListener() {
        messageTemplates = new HashMap<>();
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

        if (currentTemplate != null) {
            String uncapitalize = uncapitalize(newMessageTemplate.getClassName());

            if (reservedWord(uncapitalize)) {
                throw new InvalidFieldNameException("Can not name a field with a reserved word => " + uncapitalize);
            }

            currentTemplate
                    .addField(
                            newMessageTemplate.getClassName(),
                            uncapitalize);
        }

        currentTemplate = newMessageTemplate;
    }

    @Override
    public void exitMessageDeclaration(@NotNull LaserRaptorParser.MessageDeclarationContext ctx) {
        if (currentTemplate != null) {
            currentTemplate = messageTemplates.get(currentTemplate.getClassName());
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

        currentTemplate
                .addField(messageFieldType, fieldNameText);
    }

    public Map<String, MessageTemplate> getMessageTemplates() {
        return messageTemplates;
    }
}
