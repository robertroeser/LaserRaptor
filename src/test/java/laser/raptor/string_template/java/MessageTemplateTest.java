package laser.raptor.string_template.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTemplateTest {
    @Test
    public void testCreateMessageTemplate() throws Exception {
        MessageTemplate.newMessageTemplate();
    }

    @Test
    public void testRenderFields() throws Exception {
        String fieldsTest = MessageTemplate
                .newMessageTemplate()
                .addField(MessageTemplate.MessageFieldTypes.BYTE, "aByte")
                .addField(MessageTemplate.MessageFieldTypes.BYTE_ARRAY, "aByteArray")
                .addField(MessageTemplate.MessageFieldTypes.DOUBLE, "aDouble")
                .addField(MessageTemplate.MessageFieldTypes.LIST, "aList")
                .renderFields();

        assertNotNull(fieldsTest);
        System.out.println(fieldsTest);
    }

    @Test
    public void testRenderGetters() throws Exception {
        String gettersTest = MessageTemplate
                .newMessageTemplate()
                .addField(MessageTemplate.MessageFieldTypes.BYTE, "aByte")
                .addField(MessageTemplate.MessageFieldTypes.BYTE_ARRAY, "aByteArray")
                .addField(MessageTemplate.MessageFieldTypes.DOUBLE, "aDouble")
                .addField(MessageTemplate.MessageFieldTypes.LIST, "aList")
                .renderGetters();

        assertNotNull(gettersTest);
        System.out.println(gettersTest);
    }


    @Test
    public void testRenderSetters() throws Exception {
        String settersTest = MessageTemplate
                .newMessageTemplate()
                .addField(MessageTemplate.MessageFieldTypes.BYTE, "aByte")
                .addField(MessageTemplate.MessageFieldTypes.BYTE_ARRAY, "aByteArray")
                .addField(MessageTemplate.MessageFieldTypes.DOUBLE, "aDouble")
                .addField(MessageTemplate.MessageFieldTypes.LIST, "aList")
                .renderSetters();

        assertNotNull(settersTest);
        System.out.println(settersTest);
    }

    @Test
    public void testRenderMessageTemplate() throws Exception {
        String lasorRaptorTest = MessageTemplate
                .newMessageTemplate()
                .packageName("laser.raptor.test")
                .<MessageTemplate>className("LasorRaptorTest")
                .addField(MessageTemplate.MessageFieldTypes.BYTE, "aByte")
                .addField(MessageTemplate.MessageFieldTypes.BYTE_ARRAY, "aByteArray")
                .addField(MessageTemplate.MessageFieldTypes.DOUBLE, "aDouble")
                .addField(MessageTemplate.MessageFieldTypes.LIST, "aList")
                .addField(MessageTemplate.MessageFieldTypes.SHORT, "aShort")
                .addField(MessageTemplate.MessageFieldTypes.MAP, "aMap")
                .addField("laser.raptor.test.Foo", "aFooToPitty")
                .render();

        assertNotNull(lasorRaptorTest);
        System.out.println(lasorRaptorTest);
    }

}