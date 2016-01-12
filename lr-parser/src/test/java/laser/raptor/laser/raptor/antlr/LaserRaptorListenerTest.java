package laser.raptor.laser.raptor.antlr;

import laser.raptor.antlr.generated.LaserRaptorLexer;
import laser.raptor.antlr.generated.LaserRaptorParser;
import laser.raptor.core.InteractionModel;
import laser.raptor.string_template.java.ClientServiceTemplate;
import laser.raptor.string_template.java.MessageTemplate;
import laser.raptor.string_template.java.ServerServiceTemplate;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.net.URL;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LaserRaptorListenerTest {
    @Test
    public void testShouldParseValidIDL() throws Exception {
        URL systemResource =
            ClassLoader.getSystemResource("test.lr");
        LaserRaptorLexer lexer = new LaserRaptorLexer(new ANTLRFileStream(systemResource.getFile()));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        LaserRaptorParser parser = new LaserRaptorParser(tokenStream);
        ParserRuleContext laserRaptorContext = parser.laserRaptor();
        System.out.println(laserRaptorContext.toStringTree(parser));
    }

    @Test
    public void testShouldCreateMethodModel() throws Exception {
        URL systemResource =
            ClassLoader.getSystemResource("simpleMessage.lr");
        LaserRaptorLexer lexer = new LaserRaptorLexer(new ANTLRFileStream(systemResource.getFile()));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        LaserRaptorParser parser = new LaserRaptorParser(tokenStream);
        ParserRuleContext laserRaptorContext = parser.laserRaptor();
        System.out.println(laserRaptorContext.toStringTree(parser));

        LaserRaptorListener laserRaptorListener = new LaserRaptorListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(laserRaptorListener, laserRaptorContext);

        Map<String, ClientServiceTemplate> clientServiceTemplates =
            laserRaptorListener.getClientServiceTemplates();
        assertTrue(clientServiceTemplates.containsKey("TestService"));

        ClientServiceTemplate testService = clientServiceTemplates.get("TestService");
        ClientServiceTemplate.MethodModel model = testService.getMethods().get(0);

        assertEquals("foo", model.getMethodName());
        assertEquals(InteractionModel.REQUEST_RESPONSE, model.getInteractionModel());

        Map<String, ServerServiceTemplate> serverServiceTemplates =
            laserRaptorListener.getServerServiceTemplates();

        ServerServiceTemplate testService1 = serverServiceTemplates.get("TestService");
        ServerServiceTemplate.ServerServiceModel serverServiceModel = testService1.getServerServiceModels().get(0);
        assertEquals("foo", serverServiceModel.getMethodName());
        assertEquals(InteractionModel.REQUEST_RESPONSE, serverServiceModel.getInteractionModel());
    }

    @Test
    public void testShouldCreateOneMessage() throws Exception {

        URL systemResource =
            ClassLoader.getSystemResource("simpleMessage.lr");
        LaserRaptorLexer lexer = new LaserRaptorLexer(new ANTLRFileStream(systemResource.getFile()));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        LaserRaptorParser parser = new LaserRaptorParser(tokenStream);
        ParserRuleContext laserRaptorContext = parser.laserRaptor();
        System.out.println(laserRaptorContext.toStringTree(parser));

        LaserRaptorListener laserRaptorListener = new LaserRaptorListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(laserRaptorListener, laserRaptorContext);

        Map<String, MessageTemplate> messageTemplates =
                laserRaptorListener.getMessageTemplates();

        assertFalse(messageTemplates.isEmpty());
        assertTrue(messageTemplates.containsKey("TestMessageRequest"));

        MessageTemplate messageTemplate = messageTemplates.get("TestMessageRequest");
        Map<String, String> fields = messageTemplate.getFields();

        assertTrue(fields.containsKey("aByte"));
        assertTrue(fields.containsKey("aShort"));
        assertTrue(fields.containsKey("aInt"));
        assertTrue(fields.containsKey("aLong"));
        assertTrue(fields.containsKey("aFloat"));
        assertTrue(fields.containsKey("aDouble"));
        assertTrue(fields.containsKey("aString"));
        assertTrue(fields.containsKey("aList"));
        assertTrue(fields.containsKey("aMap"));
        assertTrue(fields.containsKey("aBinary"));

    }

    @Test
    public void testShouldCreate4MessagesMessage() throws Exception {

        URL systemResource =
            ClassLoader.getSystemResource("embeddedMessage.lr");
        LaserRaptorLexer lexer = new LaserRaptorLexer(new ANTLRFileStream(systemResource.getFile()));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        LaserRaptorParser parser = new LaserRaptorParser(tokenStream);
        ParserRuleContext laserRaptorContext = parser.laserRaptor();
        System.out.println(laserRaptorContext.toStringTree(parser));

        LaserRaptorListener laserRaptorListener = new LaserRaptorListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(laserRaptorListener, laserRaptorContext);

        Map<String, MessageTemplate> messageTemplates =
                laserRaptorListener.getMessageTemplates();

        assertFalse(messageTemplates.isEmpty());
        assertTrue(messageTemplates.containsKey("E0"));
        assertTrue(messageTemplates.containsKey("E1"));
        assertTrue(messageTemplates.containsKey("E2"));
        assertTrue(messageTemplates.containsKey("E3"));

        MessageTemplate messageTemplate = messageTemplates.get("E0");

        Map<String, String> fields = messageTemplate.getFields();
        assertTrue(fields.containsKey("e1"));
        assertTrue(fields.containsKey("aByte"));
        assertTrue(fields.containsKey("aShort"));
        assertTrue(fields.containsKey("aInt"));
        assertTrue(fields.containsKey("aLong"));
        assertTrue(fields.containsKey("aFloat"));
        assertTrue(fields.containsKey("aDouble"));
        assertTrue(fields.containsKey("aString"));
        assertTrue(fields.containsKey("aList"));
        assertTrue(fields.containsKey("aMap"));
        assertTrue(fields.containsKey("aBinary"));
    }

    @Test(expected = DuplicateFieldNameException.class)
    public void testShouldThrowExceptionBecauseOfDuplicateFields() throws Exception {
        parse("duplicateFieldsMessage.lr");
    }

    @Test(expected = InvalidMessageNameException.class)
    public void testShouldThrowExceptionBecauseOfInvalidMessageName() throws Exception {
        parse("messageWithInvalidName.lr");
    }


    @Test(expected = InvalidMessageNameException.class)
    public void testShouldThrowExceptionBecauseOfInvalidFieldName() throws Exception {
        parse("messageWithInvalidName.lr");
    }
    @Test(expected = DuplicateServiceFunctionException.class)
    public void testShouldThrowExceptionBecauseOfDuplicateServiceFunctions() throws Exception {
        parse("duplicateServiceFunction.lr");
    }

    public void parse(String fileName) throws Exception {

        URL systemResource =
                ClassLoader.getSystemResource(fileName);

        LaserRaptorLexer lexer = new LaserRaptorLexer(new ANTLRFileStream(systemResource.getFile()));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        LaserRaptorParser parser = new LaserRaptorParser(tokenStream);
        ParserRuleContext laserRaptorContext = parser.laserRaptor();
        System.out.println(laserRaptorContext.toStringTree(parser));

        LaserRaptorListener laserRaptorListener = new LaserRaptorListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(laserRaptorListener, laserRaptorContext);
    }

}