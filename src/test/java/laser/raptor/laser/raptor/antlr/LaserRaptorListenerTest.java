package laser.raptor.laser.raptor.antlr;

import laser.raptor.antlr.generated.LaserRaptorLexer;
import laser.raptor.antlr.generated.LaserRaptorParser;
import laser.raptor.string_template.java.MessageTemplate;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.net.URL;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by rroeser on 11/26/15.
 */
public class LaserRaptorListenerTest {
    @Test
    public void testShouldParseValidIDL() throws Exception {
        LaserRaptorLexer lexer = new LaserRaptorLexer(new ANTLRFileStream("/Users/rroeser/projects/LaserRaptor/src/test/resources/test.lr"));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        LaserRaptorParser parser = new LaserRaptorParser(tokenStream);
        ParserRuleContext laserRaptorContext = parser.laserRaptor();
        System.out.println(laserRaptorContext.toStringTree(parser));
    }

    @Test
    public void testShouldCreateOneMessage() throws Exception {
        LaserRaptorLexer lexer = new LaserRaptorLexer(new ANTLRFileStream("/Users/rroeser/projects/LaserRaptor/src/test/resources/simpleMessage.lr"));
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
        LaserRaptorLexer lexer = new LaserRaptorLexer(new ANTLRFileStream("/Users/rroeser/projects/LaserRaptor/src/test/resources/embeddedMessage.lr"));
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