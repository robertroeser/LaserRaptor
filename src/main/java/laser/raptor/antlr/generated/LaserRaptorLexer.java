// Generated from /Users/rroeser/projects/LaserRaptor/src/main/antlr4/LaserRaptor.g4 by ANTLR 4.2.2

package laser.raptor.antlr.generated;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LaserRaptorLexer extends Lexer {
    public static final int
            T__17 = 1, T__16 = 2, T__15 = 3, T__14 = 4, T__13 = 5, T__12 = 6, T__11 = 7, T__10 = 8,
            T__9 = 9, T__8 = 10, T__7 = 11, T__6 = 12, T__5 = 13, T__4 = 14, T__3 = 15, T__2 = 16,
            T__1 = 17, T__0 = 18, Request = 19, RequestN = 20, Subscribe = 21, Channel = 22, Fire = 23,
            Identifier = 24, WS = 25, COMMENT = 26, LINE_COMMENT = 27;
    public static final String[] tokenNames = {
            "<INVALID>",
            "'service'", "'long'", "'float'", "'{'", "';'", "'list'", "'byte'", "'}'",
            "'namespace'", "'short'", "'returns'", "'string'", "'map'", "'double'",
            "'int'", "'binary'", "'message'", "'.'", "'request'", "'requestN'", "'subscribe'",
            "'channel'", "'fire'", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
    };
    public static final String[] ruleNames = {
            "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10",
            "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1",
            "T__0", "Request", "RequestN", "Subscribe", "Channel", "Fire", "Identifier",
            "Letter", "LetterOrDigit", "WS", "COMMENT", "LINE_COMMENT"
    };
    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u0100\b\1\4\2" +
                    "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
                    "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" +
                    "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31" +
                    "\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3" +
                    "\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5" +
                    "\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3" +
                    "\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3" +
                    "\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17" +
                    "\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21" +
                    "\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24" +
                    "\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25" +
                    "\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27" +
                    "\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\7\31" +
                    "\u00ca\n\31\f\31\16\31\u00cd\13\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32" +
                    "\u00d5\n\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00dd\n\33\3\34\3\34\3" +
                    "\34\3\34\3\35\3\35\3\35\3\35\7\35\u00e7\n\35\f\35\16\35\u00ea\13\35\3" +
                    "\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00f5\n\36\f\36\16\36" +
                    "\u00f8\13\36\3\36\5\36\u00fb\n\36\3\36\3\36\3\36\3\36\3\u00e8\2\37\3\3" +
                    "\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21" +
                    "!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\2\65\2\67\339\34;\35\3\2\t" +
                    "\6\2&&C\\aac|\4\2\2\u0101\ud802\udc01\3\2\ud802\udc01\3\2\udc02\ue001" +
                    "\7\2&&\62;C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u0105\2\3\3\2\2\2\2" +
                    "\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2" +
                    "\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2" +
                    "\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2" +
                    "\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2" +
                    "\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5E\3\2\2\2\7J\3\2\2\2\t" +
                    "P\3\2\2\2\13R\3\2\2\2\rT\3\2\2\2\17Y\3\2\2\2\21^\3\2\2\2\23`\3\2\2\2\25" +
                    "j\3\2\2\2\27p\3\2\2\2\31x\3\2\2\2\33\177\3\2\2\2\35\u0083\3\2\2\2\37\u008a" +
                    "\3\2\2\2!\u008e\3\2\2\2#\u0095\3\2\2\2%\u009d\3\2\2\2\'\u009f\3\2\2\2" +
                    ")\u00a7\3\2\2\2+\u00b0\3\2\2\2-\u00ba\3\2\2\2/\u00c2\3\2\2\2\61\u00c7" +
                    "\3\2\2\2\63\u00d4\3\2\2\2\65\u00dc\3\2\2\2\67\u00de\3\2\2\29\u00e2\3\2" +
                    "\2\2;\u00f0\3\2\2\2=>\7u\2\2>?\7g\2\2?@\7t\2\2@A\7x\2\2AB\7k\2\2BC\7e" +
                    "\2\2CD\7g\2\2D\4\3\2\2\2EF\7n\2\2FG\7q\2\2GH\7p\2\2HI\7i\2\2I\6\3\2\2" +
                    "\2JK\7h\2\2KL\7n\2\2LM\7q\2\2MN\7c\2\2NO\7v\2\2O\b\3\2\2\2PQ\7}\2\2Q\n" +
                    "\3\2\2\2RS\7=\2\2S\f\3\2\2\2TU\7n\2\2UV\7k\2\2VW\7u\2\2WX\7v\2\2X\16\3" +
                    "\2\2\2YZ\7d\2\2Z[\7{\2\2[\\\7v\2\2\\]\7g\2\2]\20\3\2\2\2^_\7\177\2\2_" +
                    "\22\3\2\2\2`a\7p\2\2ab\7c\2\2bc\7o\2\2cd\7g\2\2de\7u\2\2ef\7r\2\2fg\7" +
                    "c\2\2gh\7e\2\2hi\7g\2\2i\24\3\2\2\2jk\7u\2\2kl\7j\2\2lm\7q\2\2mn\7t\2" +
                    "\2no\7v\2\2o\26\3\2\2\2pq\7t\2\2qr\7g\2\2rs\7v\2\2st\7w\2\2tu\7t\2\2u" +
                    "v\7p\2\2vw\7u\2\2w\30\3\2\2\2xy\7u\2\2yz\7v\2\2z{\7t\2\2{|\7k\2\2|}\7" +
                    "p\2\2}~\7i\2\2~\32\3\2\2\2\177\u0080\7o\2\2\u0080\u0081\7c\2\2\u0081\u0082" +
                    "\7r\2\2\u0082\34\3\2\2\2\u0083\u0084\7f\2\2\u0084\u0085\7q\2\2\u0085\u0086" +
                    "\7w\2\2\u0086\u0087\7d\2\2\u0087\u0088\7n\2\2\u0088\u0089\7g\2\2\u0089" +
                    "\36\3\2\2\2\u008a\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c\u008d\7v\2\2\u008d" +
                    " \3\2\2\2\u008e\u008f\7d\2\2\u008f\u0090\7k\2\2\u0090\u0091\7p\2\2\u0091" +
                    "\u0092\7c\2\2\u0092\u0093\7t\2\2\u0093\u0094\7{\2\2\u0094\"\3\2\2\2\u0095" +
                    "\u0096\7o\2\2\u0096\u0097\7g\2\2\u0097\u0098\7u\2\2\u0098\u0099\7u\2\2" +
                    "\u0099\u009a\7c\2\2\u009a\u009b\7i\2\2\u009b\u009c\7g\2\2\u009c$\3\2\2" +
                    "\2\u009d\u009e\7\60\2\2\u009e&\3\2\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1" +
                    "\7g\2\2\u00a1\u00a2\7s\2\2\u00a2\u00a3\7w\2\2\u00a3\u00a4\7g\2\2\u00a4" +
                    "\u00a5\7u\2\2\u00a5\u00a6\7v\2\2\u00a6(\3\2\2\2\u00a7\u00a8\7t\2\2\u00a8" +
                    "\u00a9\7g\2\2\u00a9\u00aa\7s\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac\7g\2\2" +
                    "\u00ac\u00ad\7u\2\2\u00ad\u00ae\7v\2\2\u00ae\u00af\7P\2\2\u00af*\3\2\2" +
                    "\2\u00b0\u00b1\7u\2\2\u00b1\u00b2\7w\2\2\u00b2\u00b3\7d\2\2\u00b3\u00b4" +
                    "\7u\2\2\u00b4\u00b5\7e\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7\7k\2\2\u00b7" +
                    "\u00b8\7d\2\2\u00b8\u00b9\7g\2\2\u00b9,\3\2\2\2\u00ba\u00bb\7e\2\2\u00bb" +
                    "\u00bc\7j\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7p\2\2\u00be\u00bf\7p\2\2" +
                    "\u00bf\u00c0\7g\2\2\u00c0\u00c1\7n\2\2\u00c1.\3\2\2\2\u00c2\u00c3\7h\2" +
                    "\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7g\2\2\u00c6\60\3" +
                    "\2\2\2\u00c7\u00cb\5\63\32\2\u00c8\u00ca\5\65\33\2\u00c9\u00c8\3\2\2\2" +
                    "\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\62" +
                    "\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d5\t\2\2\2\u00cf\u00d0\n\3\2\2\u00d0" +
                    "\u00d5\6\32\2\2\u00d1\u00d2\t\4\2\2\u00d2\u00d3\t\5\2\2\u00d3\u00d5\6" +
                    "\32\3\2\u00d4\u00ce\3\2\2\2\u00d4\u00cf\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d5" +
                    "\64\3\2\2\2\u00d6\u00dd\t\6\2\2\u00d7\u00d8\n\3\2\2\u00d8\u00dd\6\33\4" +
                    "\2\u00d9\u00da\t\4\2\2\u00da\u00db\t\5\2\2\u00db\u00dd\6\33\5\2\u00dc" +
                    "\u00d6\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dc\u00d9\3\2\2\2\u00dd\66\3\2\2" +
                    "\2\u00de\u00df\t\7\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\b\34\2\2\u00e1" +
                    "8\3\2\2\2\u00e2\u00e3\7\61\2\2\u00e3\u00e4\7,\2\2\u00e4\u00e8\3\2\2\2" +
                    "\u00e5\u00e7\13\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e9" +
                    "\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb" +
                    "\u00ec\7,\2\2\u00ec\u00ed\7\61\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\b\35" +
                    "\2\2\u00ef:\3\2\2\2\u00f0\u00f1\7\61\2\2\u00f1\u00f2\7\61\2\2\u00f2\u00f6" +
                    "\3\2\2\2\u00f3\u00f5\n\b\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6" +
                    "\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2" +
                    "\2\2\u00f9\u00fb\7\17\2\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb" +
                    "\u00fc\3\2\2\2\u00fc\u00fd\7\f\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\b\36" +
                    "\2\2\u00ff<\3\2\2\2\t\2\u00cb\u00d4\u00dc\u00e8\u00f6\u00fa\3\2\3\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public LaserRaptorLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "LaserRaptor.g4";
    }

    @Override
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    @Override
    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 24:
                return Letter_sempred((RuleContext) _localctx, predIndex);

            case 25:
                return LetterOrDigit_sempred((RuleContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean Letter_sempred(RuleContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return Character.isJavaIdentifierStart(_input.LA(-1));

            case 1:
                return Character.isJavaIdentifierStart(Character.toCodePoint((char) _input.LA(-2), (char) _input.LA(-1)));
        }
        return true;
    }

    private boolean LetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
        switch (predIndex) {
            case 2:
                return Character.isJavaIdentifierPart(_input.LA(-1));

            case 3:
                return Character.isJavaIdentifierPart(Character.toCodePoint((char) _input.LA(-2), (char) _input.LA(-1)));
        }
        return true;
    }
}