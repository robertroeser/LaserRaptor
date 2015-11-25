package laser.raptor.string_template.java;

import org.stringtemplate.v4.NoIndentWriter;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static laser.raptor.string_template.Util.capatilize;

public class MessageTemplate extends JavaTemplate {

    STGroup messageGroup;

    final Map<String, String> fields;

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
        BYTE_ARRAY("byte[]");

        String text;

        MessageFieldTypes(String text) {
            this.text = text;
        }
    }

    protected MessageTemplate() {
        super();

        fields = new HashMap<>();

        stGroupDir.load();
        String fileName = stGroupDir.getFileName() + File.separator + "Message.stg";
        messageGroup = new STGroupFile(fileName);
    }

    public static MessageTemplate newMessageTemplate() {
        return new MessageTemplate();
    }

    public MessageTemplate addField(MessageFieldTypes type, String name) {
        addField(name, type.text);
        return this;
    }

    public MessageTemplate addField(String type, String name) {
        fields.put(name, type);
        return this;
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
                .forEach((k,v)-> getterMap.put(k, new AccessorModel(prefix + capatilize(k), v)));

        accessor.add("fieldMap", getterMap);

        return accessor.render();
    }

    protected String renderGetters() {
        return renderAccesor("get", "getters");
    }

    protected String renderSetters() {
        return renderAccesor("set", "setters");
    }

    public String render() {
        ST message = messageGroup.getInstanceOf("message");

        message.add("generated_date", generatedDate);
        message.add("laser_raptor_version", laserRaptorVersion);
        message.add("package_name", packageName);
        message.add("class_name", className);
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
