package laser.raptor;

import laser.raptor.antlr.LaserRaptorLexer;
import laser.raptor.antlr.LaserRaptorParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.Test;

/**
 * Created by rroeser on 11/23/15.
 */
public class ParserTest {
    @Test
    public void test() throws Exception {
        LaserRaptorLexer lexer = new LaserRaptorLexer(new ANTLRFileStream("/Users/rroeser/projects/LaserRaptor/src/test/resources/test.lr"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LaserRaptorParser parser = new LaserRaptorParser(tokens);
        parser.setBuildParseTree(true);
        parser.addParseListener(new ParseTreeListener() {
            @Override
            public void visitTerminal(@NotNull TerminalNode node) {

            }

            @Override
            public void visitErrorNode(@NotNull ErrorNode node) {

            }

            @Override
            public void enterEveryRule(@NotNull ParserRuleContext ctx) {
                Token start = ctx.start;

                if (start.getType() == LaserRaptorParser.MESSAGE) {
                    System.out.println("WOOHOO - found a message");
                }

                if (start.getType() == LaserRaptorParser.RULE_message_field) {
                    System.out.println("WOOHOO - found a MESSAGE FIELD RULE");
                    RuleContext payload = ctx.getPayload();
                    for (int i = 0; i < payload.getChildCount(); i++) {
                        payload.
                    }
                 }

            }

            @Override
            public void exitEveryRule(@NotNull ParserRuleContext ctx) {

            }
        });
        parser.laser_raptor();

    }
}


    /*
    ANTLRInputStream input = new ANTLRFileStream(args[0]);
        CfscriptLexer lexer = new CfscriptLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CfscriptParser parser = new CfscriptParser(tokens);
        parser.setBuildParseTree(true);
        ParserRuleContext tree = parser.component();
        tree.inspect(parser); // show in gui


    RowsLexer lexer = new RowsLexer(input);
CommonTokenStream tokens = new CommonTokenStream(lexer);
int col = Integer.valueOf(args[0]);
• Click HERE to purchase this book now. discuss
Making Things Happen During the Parse • 7
RowsParser parser = new RowsParser(tokens, col); // pass column number!
parser.file(); // parse

 MuLexer lexer = new MuLexer(new ANTLRFileStream("test.mu"));
        MuParser parser = new MuParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
     */
