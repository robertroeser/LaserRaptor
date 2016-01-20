package laser.raptor.string_template.java;


import org.junit.Assert;
import org.junit.Test;

public class GuiceModuleTemplateTest {
    @Test
    public void testRender() {
        GuiceModuleTemplate guiceModuleTemplate = GuiceModuleTemplate.newGuiceModuleTemplate();
        guiceModuleTemplate.addClassToBind("Foo");
        guiceModuleTemplate.addClassToBind("Bar");
        guiceModuleTemplate.addClassToBind("Baz");
        guiceModuleTemplate.packageName("laser.raptor");

        String render = guiceModuleTemplate.render();

        System.out.println(render);

        Assert.assertTrue(render.contains("Foo.class"));
        Assert.assertTrue(render.contains("Bar.class"));
        Assert.assertTrue(render.contains("Baz.class"));
    }

}