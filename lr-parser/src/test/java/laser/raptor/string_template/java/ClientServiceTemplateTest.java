package laser.raptor.string_template.java;


import laser.raptor.core.InteractionModel;
import org.junit.Assert;
import org.junit.Test;

public class ClientServiceTemplateTest {
    @Test
    public void testCreateClientServiceTemplate() throws Exception {
        ClientServiceTemplate.newClientServiceTemplate();
    }

    @Test
    public void testFireAndForget() throws Exception {
        ClientServiceTemplate.MethodModel model =
            new ClientServiceTemplate.MethodModel(InteractionModel.FIRE_AND_FORGET, "String", "String", "foo", 1, 1);

        String method = ClientServiceTemplate
            .newClientServiceTemplate()
            .renderMethod(model);

        Assert.assertNotNull(method);
        System.out.println(method);
    }

    @Test
    public void testRenderRequestResponse() throws Exception {
        ClientServiceTemplate.MethodModel model =
            new ClientServiceTemplate.MethodModel(InteractionModel.REQUEST_RESPONSE, "String", "String", "foo", 1, 1);

        String method = ClientServiceTemplate
            .newClientServiceTemplate()
            .renderMethod(model);

        Assert.assertNotNull(method);
        System.out.println(method);
    }

    @Test
    public void testRequestStream() throws Exception {
        ClientServiceTemplate.MethodModel model =
            new ClientServiceTemplate.MethodModel(InteractionModel.REQUEST_STREAM, "String", "String", "foo", 1, 1);

        String method = ClientServiceTemplate
            .newClientServiceTemplate()
            .renderMethod(model);

        Assert.assertNotNull(method);
        System.out.println(method);
    }

    @Test
    public void testSubscription() throws Exception {
        ClientServiceTemplate.MethodModel model =
            new ClientServiceTemplate.MethodModel(InteractionModel.SUBSCRIPTION, "String", "String", "foo", 1, 1);

        String method = ClientServiceTemplate
            .newClientServiceTemplate()
            .renderMethod(model);

        Assert.assertNotNull(method);
        System.out.println(method);
    }

    @Test
    public void testHandleChannel() throws Exception {
        ClientServiceTemplate.MethodModel model =
            new ClientServiceTemplate.MethodModel(InteractionModel.CHANNEL, "String", "String", "foo", 1, 1);

        String method = ClientServiceTemplate
            .newClientServiceTemplate()
            .renderMethod(model);

        Assert.assertNotNull(method);
        System.out.println(method);
    }

    @Test
    public void testRender() throws Exception {

        ClientServiceTemplate.MethodModel model1 =
            new ClientServiceTemplate.MethodModel(InteractionModel.SUBSCRIPTION, "String", "String", "fooSub", 1, 1);

        ClientServiceTemplate.MethodModel model2 =
            new ClientServiceTemplate.MethodModel(InteractionModel.CHANNEL, "String", "String", "foo", 1, 1);

        String method = ClientServiceTemplate
            .newClientServiceTemplate()
            .className("Foo")
            .<ClientServiceTemplate>packageName("laser.rapter.client")
            .addMethod(model1)
            .addMethod(model2)
            .render();

        Assert.assertNotNull(method);
        System.out.println(method);
    }
}