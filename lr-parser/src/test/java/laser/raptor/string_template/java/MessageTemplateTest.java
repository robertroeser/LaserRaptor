package laser.raptor.string_template.java;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MessageTemplateTest {
    @Test
    public void testCreateMessageTemplate() throws Exception {
        MessageTemplate.newMessageTemplate();
    }

    @Test
    public void testRenderEnum() throws Exception {
        String enumsTest = MessageTemplate
            .newMessageTemplate()
            .addEnum("one", "ONE, TWO, THREE")
            .addEnum("two", "ONE, TWO, THREE, FOUR")
            .renderEnums();

        assertNotNull(enumsTest);
        System.out.println(enumsTest);
    }

    @Test
    public void testRenderFields() throws Exception {
        String fieldsTest = MessageTemplate
                .newMessageTemplate()
                .addField(MessageTemplate.MessageFieldTypes.BYTE, "aByte")
                .addField(MessageTemplate.MessageFieldTypes.BINARY, "aByteArray")
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
                .addField(MessageTemplate.MessageFieldTypes.BINARY, "aByteArray")
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
                .addField(MessageTemplate.MessageFieldTypes.BINARY, "aByteArray")
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
                .addField(MessageTemplate.MessageFieldTypes.BINARY, "aByteArray")
                .addField(MessageTemplate.MessageFieldTypes.DOUBLE, "aDouble")
                .addField(MessageTemplate.MessageFieldTypes.LIST, "aList")
                .addField(MessageTemplate.MessageFieldTypes.SHORT, "aShort")
                .addField(MessageTemplate.MessageFieldTypes.MAP, "aMap")
                .addField(MessageTemplate.MessageFieldTypes.STRING, "aString")
                .addField(MessageTemplate.MessageFieldTypes.INT, "aInt")
                .addField(MessageTemplate.MessageFieldTypes.LONG, "aLong")
                .addField(MessageTemplate.MessageFieldTypes.FLOAT, "aFloat")
                .addField("laser.raptor.test.Foo", "aFooToPitty")
                .addEnum("one", "ONE, TWO, THREE")
                .addEnum("two", "ONE, TWO, THREE, FOUR")
                .render();

        assertNotNull(lasorRaptorTest);
        System.out.println(lasorRaptorTest);
    }
}