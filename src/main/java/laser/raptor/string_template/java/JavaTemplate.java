package laser.raptor.string_template.java;

import laser.raptor.string_template.Template;

@SuppressWarnings("unchecked")
public abstract class JavaTemplate extends Template {
    protected String packageName;
    protected String className;

    protected JavaTemplate() {
        super("templates/java");
    }

    protected <T extends JavaTemplate> T packageName(String packageName) {
        this.packageName = packageName;
        return (T) this;
    }

    protected <T extends JavaTemplate> T className(String className) {
        this.className = className;
        return (T) this;
    }
}
