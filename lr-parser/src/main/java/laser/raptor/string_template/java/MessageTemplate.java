package laser.raptor.string_template.java;

import laser.raptor.laser.raptor.antlr.DuplicateFieldNameException;
import org.stringtemplate.v4.NoIndentWriter;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static laser.raptor.string_template.Util.capitalize;

public class MessageTemplate extends JavaTemplate {
    final Map<String, String> fields;
    final Map<String, List<String>> enums;
    STGroup messageGroup;

    protected MessageTemplate() {
        super();

        fields = new HashMap<>();
        enums = new HashMap<>();

        stGroupDir.load();
        String fileName = "templates/java/Message.stg";
        messageGroup = new STGroupFile(fileName);

    }

    public static MessageTemplate newMessageTemplate() {
        return new MessageTemplate();
    }

    public MessageTemplate addEnum(String name, String... literals) {
        // Need to add a field for each enum
        String enumName = capitalize(name);
        addField(enumName, name);

        enums.putIfAbsent(enumName, Arrays.asList(literals));
        return this;
    }

    public MessageTemplate addField(MessageFieldTypes type, String name) {
        addField(type.text, name);
        return this;
    }

    public MessageTemplate addField(String type, String name) {
        if (fields.containsKey(name)) {
            throw new DuplicateFieldNameException("Duplicate field " + name + " found");
        }

        fields.put(name, type);
        return this;
    }

    protected String renderEnums() {

        StringBuilder enums = new StringBuilder();

        this
            .enums
            .forEach((s, strings) -> {
                StringBuilder literals = new StringBuilder();
                strings
                    .forEach(literal -> {
                        literals.append(literal);

                        if (!(strings.get(strings.size() - 1).equalsIgnoreCase(literal))) {
                            literals.append(",");
                        }
                    });

                ST _enum = messageGroup.getInstanceOf("enum");
                _enum.add("name", s);
                _enum.add("literals", literals.toString());
                String render = _enum.render();
                enums.append(render);
            });

        return enums.toString();
    }

    protected String renderFields() {
        ST fields = messageGroup.getInstanceOf("fields");

        fields.add("fieldMap", this.fields);

        return fields.render();
    }

    protected String renderAccesor(String prefix, String template) {
        ST accessor = messageGroup.getInstanceOf(template);

        Map<String, AccessorModel> getterMap = new HashMap<>();

        fields
                .forEach((k, v) -> getterMap.put(k, new AccessorModel(prefix + capitalize(k), v)));

        accessor.add("fieldMap", getterMap);

        return accessor.render();
    }

    protected String renderGetters() {
        return renderAccesor("get", "getters");
    }

    protected String renderSetters() {
        return renderAccesor("set", "setters");
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public String render() {
        ST message = messageGroup.getInstanceOf("message");

        message.add("generated_date", generatedDate);
        message.add("laser_raptor_version", laserRaptorVersion);
        message.add("package_name", packageName);
        message.add("class_name", className);
        // The order is important - enums need to rendered before the fields because adding an enum will add a field
        message.add("enums", renderEnums());
        message.add("fields", renderFields());
        message.add("setters", renderSetters());
        message.add("getters", renderGetters());

        StringWriter stringWriter = new StringWriter();
        NoIndentWriter writer = new NoIndentWriter(stringWriter);
        try {
            message.write(writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringWriter.toString();
    }

    public enum MessageFieldTypes {
        BYTE("byte"),
        SHORT("short"),
        INT("int"),
        LONG("long"),
        FLOAT("float"),
        DOUBLE("double"),
        STRING("String"),
        LIST("java.util.List"),
        MAP("java.util.Map"),
        BINARY("byte[]");

        String text;

        MessageFieldTypes(String text) {
            this.text = text;
        }
    }

    public class AccessorModel {
        String accessorName;
        String type;

        public AccessorModel(String accessorName, String type) {
            this.accessorName = accessorName;
            this.type = type;
        }

        public String getAccessorName() {
            return accessorName;
        }

        public void setAccessorName(String accessorName) {
            this.accessorName = accessorName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
