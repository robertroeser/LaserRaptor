package laser.raptor.string_template.java;


import laser.raptor.core.InteractionModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ServerServiceTemplateTest {
    @Test
    public void testCreateServerServiceTemplate() {
        ServerServiceTemplate.newServerServiceTemplate();
    }

    @Test
    public void testRenderRequestReply() {
        ServerServiceTemplate serverServiceTemplate
            = ServerServiceTemplate.newServerServiceTemplate();

        ServerServiceTemplate.ServerServiceModel model =
            new ServerServiceTemplate.ServerServiceModel(
                InteractionModel.REQUEST_RESPONSE,
                "String", "String", "foo", 1, 1);

        String function = serverServiceTemplate.renderFunction(model);

        Assert.assertNotNull(function);
        System.out.println(function);
    }

    @Test
    public void testRenderFireAndForget() {
        ServerServiceTemplate serverServiceTemplate
            = ServerServiceTemplate.newServerServiceTemplate();

        ServerServiceTemplate.ServerServiceModel model =
            new ServerServiceTemplate.ServerServiceModel(
                InteractionModel.FIRE_AND_FORGET,
                "String", "String", "foo", 1, 1);

        String function = serverServiceTemplate.renderFunction(model);

        Assert.assertNotNull(function);
        System.out.println(function);
    }

    @Test
    public void testRenderRequestStream() {
        ServerServiceTemplate serverServiceTemplate
            = ServerServiceTemplate.newServerServiceTemplate();

        ServerServiceTemplate.ServerServiceModel model =
            new ServerServiceTemplate.ServerServiceModel(
                InteractionModel.REQUEST_STREAM,
                "String", "String", "foo", 1, 1);

        String function = serverServiceTemplate.renderFunction(model);

        Assert.assertNotNull(function);
        System.out.println(function);
    }

    @Test
    public void testRenderChannel() {
        ServerServiceTemplate serverServiceTemplate
            = ServerServiceTemplate.newServerServiceTemplate();

        ServerServiceTemplate.ServerServiceModel model =
            new ServerServiceTemplate.ServerServiceModel(
                InteractionModel.CHANNEL,
                "String", "String", "foo", 1, 1);

        String function = serverServiceTemplate.renderFunction(model);

        Assert.assertNotNull(function);
        System.out.println(function);
    }

    @Test
    public void testRenderSubscription() {
        ServerServiceTemplate serverServiceTemplate
            = ServerServiceTemplate.newServerServiceTemplate();

        ServerServiceTemplate.ServerServiceModel model =
            new ServerServiceTemplate.ServerServiceModel(
                InteractionModel.CHANNEL,
                "String", "String", "foo", 1, 1);

        String function = serverServiceTemplate.renderFunction(model);

        Assert.assertNotNull(function);
        System.out.println(function);
    }

    @Test
    public void testRender() {
        ServerServiceTemplate serverServiceTemplate
            = ServerServiceTemplate.newServerServiceTemplate();

        ServerServiceTemplate.ServerServiceModel model =
            new ServerServiceTemplate.ServerServiceModel(
                InteractionModel.REQUEST_RESPONSE,
                "String", "String", "foo", 1, 1);

        serverServiceTemplate.addServerService(model);
        serverServiceTemplate.packageName("laser.raptor");
        serverServiceTemplate.className("FooService");

        List<String> render = serverServiceTemplate.render();
        render.forEach(s -> {
            Assert.assertNotNull(s);
            System.out.println(s);
            Assert.assertTrue(s.contains("public class foo implements RequestResponseServerFunction<String, String> {"));
        });
    }

    @Test
    public void testRenderMultiple() {
        ServerServiceTemplate serverServiceTemplate
            = ServerServiceTemplate.newServerServiceTemplate();

        ServerServiceTemplate.ServerServiceModel model =
            new ServerServiceTemplate.ServerServiceModel(
                InteractionModel.REQUEST_RESPONSE,
                "String", "String", "foo1", 1, 1);

        ServerServiceTemplate.ServerServiceModel model1 =
            new ServerServiceTemplate.ServerServiceModel(
                InteractionModel.REQUEST_RESPONSE,
                "String", "String", "foo2", 1, 2);

        ServerServiceTemplate.ServerServiceModel model2 =
            new ServerServiceTemplate.ServerServiceModel(
                InteractionModel.REQUEST_RESPONSE,
                "String", "String", "foo3", 1, 3);


        serverServiceTemplate
            .addServerService(model)
            .addServerService(model1)
            .addServerService(model2)
            .packageName("laser.raptor")
            .className("FooService");

        List<String> render = serverServiceTemplate.render();
        render.forEach(s -> {
            Assert.assertNotNull(s);
            System.out.println(s);

        });

    }

}