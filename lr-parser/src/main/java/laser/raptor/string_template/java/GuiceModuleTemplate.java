package laser.raptor.string_template.java;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.ArrayList;
import java.util.List;

public class GuiceModuleTemplate extends  JavaTemplate {
    final List<String> classes;
    STGroup guiceConfigGroup;

    protected GuiceModuleTemplate() {
        super();

        this.className("GeneratedGuiceConfig");

        guiceConfigGroup = new STGroupFile("templates/java/LaserRaptorGuiceServerModule.stg");

        classes = new ArrayList<>();
    }

    public static GuiceModuleTemplate newGuiceModuleTemplate() {
        return new GuiceModuleTemplate();
    }

    public GuiceModuleTemplate addClassToBind(String className) {
        classes.add(className);
        return this;
    }

    protected String renderBinding(String className) {
        ST template = guiceConfigGroup
            .getInstanceOf("binding");

        template.add("class_name", className);

        return template.render();
    }

    public String render() {
        ST service = guiceConfigGroup.getInstanceOf("config");

        service.add("generated_date", generatedDate);
        service.add("laser_raptor_version", laserRaptorVersion);
        service.add("package_name", packageName);


        StringBuilder sb = new StringBuilder();

        classes
            .stream()
            .map(this::renderBinding)
            .forEach(sb::append);

        service.add("multibindings", sb.toString());

        return service.render();
    }
}
