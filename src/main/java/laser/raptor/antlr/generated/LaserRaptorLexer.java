// Generated from /Users/rroeser/projects/LaserRaptor/src/main/antlr4/LaserRaptor.g4 by ANTLR 4.2.2

package laser.raptor.antlr.generated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LaserRaptorLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		Identifier=17, WS=18, COMMENT=19, LINE_COMMENT=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'long'", "'float'", "'{'", "';'", "'list'", "'byte'", "'}'", "'namespace'", 
		"'short'", "'string'", "'map'", "'double'", "'int'", "'binary'", "'message'", 
		"'.'", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Identifier", 
		"Letter", "LetterOrDigit", "WS", "COMMENT", "LINE_COMMENT"
	};


	public LaserRaptorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LaserRaptor.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17: return Letter_sempred((RuleContext)_localctx, predIndex);

		case 18: return LetterOrDigit_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean Letter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return Character.isJavaIdentifierStart(_input.LA(-1));

		case 1: return Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}
	private boolean LetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return Character.isJavaIdentifierPart(_input.LA(-1));

		case 3: return Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u00ba\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3"+
		"\22\7\22\u0084\n\22\f\22\16\22\u0087\13\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\5\23\u008f\n\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0097\n\24\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u00a1\n\26\f\26\16\26\u00a4\13"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u00af\n\27\f\27"+
		"\16\27\u00b2\13\27\3\27\5\27\u00b5\n\27\3\27\3\27\3\27\3\27\3\u00a2\2"+
		"\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\2\'\2)\24+\25-\26\3\2\t\6\2&&C\\aac|\4\2\2\u0101\ud802"+
		"\udc01\3\2\ud802\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17"+
		"\"\"\4\2\f\f\17\17\u00bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2"+
		"\5\64\3\2\2\2\7:\3\2\2\2\t<\3\2\2\2\13>\3\2\2\2\rC\3\2\2\2\17H\3\2\2\2"+
		"\21J\3\2\2\2\23T\3\2\2\2\25Z\3\2\2\2\27a\3\2\2\2\31e\3\2\2\2\33l\3\2\2"+
		"\2\35p\3\2\2\2\37w\3\2\2\2!\177\3\2\2\2#\u0081\3\2\2\2%\u008e\3\2\2\2"+
		"\'\u0096\3\2\2\2)\u0098\3\2\2\2+\u009c\3\2\2\2-\u00aa\3\2\2\2/\60\7n\2"+
		"\2\60\61\7q\2\2\61\62\7p\2\2\62\63\7i\2\2\63\4\3\2\2\2\64\65\7h\2\2\65"+
		"\66\7n\2\2\66\67\7q\2\2\678\7c\2\289\7v\2\29\6\3\2\2\2:;\7}\2\2;\b\3\2"+
		"\2\2<=\7=\2\2=\n\3\2\2\2>?\7n\2\2?@\7k\2\2@A\7u\2\2AB\7v\2\2B\f\3\2\2"+
		"\2CD\7d\2\2DE\7{\2\2EF\7v\2\2FG\7g\2\2G\16\3\2\2\2HI\7\177\2\2I\20\3\2"+
		"\2\2JK\7p\2\2KL\7c\2\2LM\7o\2\2MN\7g\2\2NO\7u\2\2OP\7r\2\2PQ\7c\2\2QR"+
		"\7e\2\2RS\7g\2\2S\22\3\2\2\2TU\7u\2\2UV\7j\2\2VW\7q\2\2WX\7t\2\2XY\7v"+
		"\2\2Y\24\3\2\2\2Z[\7u\2\2[\\\7v\2\2\\]\7t\2\2]^\7k\2\2^_\7p\2\2_`\7i\2"+
		"\2`\26\3\2\2\2ab\7o\2\2bc\7c\2\2cd\7r\2\2d\30\3\2\2\2ef\7f\2\2fg\7q\2"+
		"\2gh\7w\2\2hi\7d\2\2ij\7n\2\2jk\7g\2\2k\32\3\2\2\2lm\7k\2\2mn\7p\2\2n"+
		"o\7v\2\2o\34\3\2\2\2pq\7d\2\2qr\7k\2\2rs\7p\2\2st\7c\2\2tu\7t\2\2uv\7"+
		"{\2\2v\36\3\2\2\2wx\7o\2\2xy\7g\2\2yz\7u\2\2z{\7u\2\2{|\7c\2\2|}\7i\2"+
		"\2}~\7g\2\2~ \3\2\2\2\177\u0080\7\60\2\2\u0080\"\3\2\2\2\u0081\u0085\5"+
		"%\23\2\u0082\u0084\5\'\24\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086$\3\2\2\2\u0087\u0085\3\2\2\2"+
		"\u0088\u008f\t\2\2\2\u0089\u008a\n\3\2\2\u008a\u008f\6\23\2\2\u008b\u008c"+
		"\t\4\2\2\u008c\u008d\t\5\2\2\u008d\u008f\6\23\3\2\u008e\u0088\3\2\2\2"+
		"\u008e\u0089\3\2\2\2\u008e\u008b\3\2\2\2\u008f&\3\2\2\2\u0090\u0097\t"+
		"\6\2\2\u0091\u0092\n\3\2\2\u0092\u0097\6\24\4\2\u0093\u0094\t\4\2\2\u0094"+
		"\u0095\t\5\2\2\u0095\u0097\6\24\5\2\u0096\u0090\3\2\2\2\u0096\u0091\3"+
		"\2\2\2\u0096\u0093\3\2\2\2\u0097(\3\2\2\2\u0098\u0099\t\7\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u009b\b\25\2\2\u009b*\3\2\2\2\u009c\u009d\7\61\2\2\u009d"+
		"\u009e\7,\2\2\u009e\u00a2\3\2\2\2\u009f\u00a1\13\2\2\2\u00a0\u009f\3\2"+
		"\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\7,\2\2\u00a6\u00a7\7\61"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\26\2\2\u00a9,\3\2\2\2\u00aa\u00ab"+
		"\7\61\2\2\u00ab\u00ac\7\61\2\2\u00ac\u00b0\3\2\2\2\u00ad\u00af\n\b\2\2"+
		"\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b5\7\17\2\2"+
		"\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7"+
		"\7\f\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\27\2\2\u00b9.\3\2\2\2\t\2\u0085"+
		"\u008e\u0096\u00a2\u00b0\u00b4\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}