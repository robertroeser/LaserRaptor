// Generated from /Users/rroeser/projects/LaserRaptor/parser/src/main/antlr4/LaserRaptor.g4 by ANTLR 4.2.2

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
		T__20=1, T__19=2, T__18=3, T__17=4, T__16=5, T__15=6, T__14=7, T__13=8, 
		T__12=9, T__11=10, T__10=11, T__9=12, T__8=13, T__7=14, T__6=15, T__5=16, 
		T__4=17, T__3=18, T__2=19, T__1=20, T__0=21, Request=22, RequestN=23, 
		Subscribe=24, Channel=25, Fire=26, Identifier=27, WS=28, COMMENT=29, LINE_COMMENT=30;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'boolean'", "'service'", "'long'", "'float'", "'{'", "';'", "'list'", 
		"'byte'", "'}'", "'enum'", "'namespace'", "'short'", "'returns'", "'string'", 
		"'map'", "'double'", "'int'", "'binary'", "'message'", "','", "'.'", "'request'", 
		"'requestN'", "'subscribe'", "'channel'", "'fire'", "Identifier", "WS", 
		"COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", 
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "Request", "RequestN", "Subscribe", "Channel", 
		"Fire", "Identifier", "Letter", "LetterOrDigit", "WS", "COMMENT", "LINE_COMMENT"
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
		case 27: return Letter_sempred((RuleContext)_localctx, predIndex);

		case 28: return LetterOrDigit_sempred((RuleContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u0115\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\7\34\u00df\n\34\f\34\16\34\u00e2\13\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\5\35\u00ea\n\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u00f2\n\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \7 \u00fc\n \f \16 \u00ff\13"+
		" \3 \3 \3 \3 \3 \3!\3!\3!\3!\7!\u010a\n!\f!\16!\u010d\13!\3!\5!\u0110"+
		"\n!\3!\3!\3!\3!\3\u00fd\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\2;\2=\36?\37A \3\2\t\6\2&&C\\aac|\4\2\2\u0101\ud802"+
		"\udc01\3\2\ud802\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17"+
		"\"\"\4\2\f\f\17\17\u011a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5K\3\2\2\2\7S\3\2\2"+
		"\2\tX\3\2\2\2\13^\3\2\2\2\r`\3\2\2\2\17b\3\2\2\2\21g\3\2\2\2\23l\3\2\2"+
		"\2\25n\3\2\2\2\27s\3\2\2\2\31}\3\2\2\2\33\u0083\3\2\2\2\35\u008b\3\2\2"+
		"\2\37\u0092\3\2\2\2!\u0096\3\2\2\2#\u009d\3\2\2\2%\u00a1\3\2\2\2\'\u00a8"+
		"\3\2\2\2)\u00b0\3\2\2\2+\u00b2\3\2\2\2-\u00b4\3\2\2\2/\u00bc\3\2\2\2\61"+
		"\u00c5\3\2\2\2\63\u00cf\3\2\2\2\65\u00d7\3\2\2\2\67\u00dc\3\2\2\29\u00e9"+
		"\3\2\2\2;\u00f1\3\2\2\2=\u00f3\3\2\2\2?\u00f7\3\2\2\2A\u0105\3\2\2\2C"+
		"D\7d\2\2DE\7q\2\2EF\7q\2\2FG\7n\2\2GH\7g\2\2HI\7c\2\2IJ\7p\2\2J\4\3\2"+
		"\2\2KL\7u\2\2LM\7g\2\2MN\7t\2\2NO\7x\2\2OP\7k\2\2PQ\7e\2\2QR\7g\2\2R\6"+
		"\3\2\2\2ST\7n\2\2TU\7q\2\2UV\7p\2\2VW\7i\2\2W\b\3\2\2\2XY\7h\2\2YZ\7n"+
		"\2\2Z[\7q\2\2[\\\7c\2\2\\]\7v\2\2]\n\3\2\2\2^_\7}\2\2_\f\3\2\2\2`a\7="+
		"\2\2a\16\3\2\2\2bc\7n\2\2cd\7k\2\2de\7u\2\2ef\7v\2\2f\20\3\2\2\2gh\7d"+
		"\2\2hi\7{\2\2ij\7v\2\2jk\7g\2\2k\22\3\2\2\2lm\7\177\2\2m\24\3\2\2\2no"+
		"\7g\2\2op\7p\2\2pq\7w\2\2qr\7o\2\2r\26\3\2\2\2st\7p\2\2tu\7c\2\2uv\7o"+
		"\2\2vw\7g\2\2wx\7u\2\2xy\7r\2\2yz\7c\2\2z{\7e\2\2{|\7g\2\2|\30\3\2\2\2"+
		"}~\7u\2\2~\177\7j\2\2\177\u0080\7q\2\2\u0080\u0081\7t\2\2\u0081\u0082"+
		"\7v\2\2\u0082\32\3\2\2\2\u0083\u0084\7t\2\2\u0084\u0085\7g\2\2\u0085\u0086"+
		"\7v\2\2\u0086\u0087\7w\2\2\u0087\u0088\7t\2\2\u0088\u0089\7p\2\2\u0089"+
		"\u008a\7u\2\2\u008a\34\3\2\2\2\u008b\u008c\7u\2\2\u008c\u008d\7v\2\2\u008d"+
		"\u008e\7t\2\2\u008e\u008f\7k\2\2\u008f\u0090\7p\2\2\u0090\u0091\7i\2\2"+
		"\u0091\36\3\2\2\2\u0092\u0093\7o\2\2\u0093\u0094\7c\2\2\u0094\u0095\7"+
		"r\2\2\u0095 \3\2\2\2\u0096\u0097\7f\2\2\u0097\u0098\7q\2\2\u0098\u0099"+
		"\7w\2\2\u0099\u009a\7d\2\2\u009a\u009b\7n\2\2\u009b\u009c\7g\2\2\u009c"+
		"\"\3\2\2\2\u009d\u009e\7k\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7v\2\2\u00a0"+
		"$\3\2\2\2\u00a1\u00a2\7d\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7p\2\2\u00a4"+
		"\u00a5\7c\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7{\2\2\u00a7&\3\2\2\2\u00a8"+
		"\u00a9\7o\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac\7u\2\2"+
		"\u00ac\u00ad\7c\2\2\u00ad\u00ae\7i\2\2\u00ae\u00af\7g\2\2\u00af(\3\2\2"+
		"\2\u00b0\u00b1\7.\2\2\u00b1*\3\2\2\2\u00b2\u00b3\7\60\2\2\u00b3,\3\2\2"+
		"\2\u00b4\u00b5\7t\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7s\2\2\u00b7\u00b8"+
		"\7w\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7v\2\2\u00bb"+
		".\3\2\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7s\2\2\u00bf"+
		"\u00c0\7w\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7v\2\2"+
		"\u00c3\u00c4\7P\2\2\u00c4\60\3\2\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7"+
		"w\2\2\u00c7\u00c8\7d\2\2\u00c8\u00c9\7u\2\2\u00c9\u00ca\7e\2\2\u00ca\u00cb"+
		"\7t\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7d\2\2\u00cd\u00ce\7g\2\2\u00ce"+
		"\62\3\2\2\2\u00cf\u00d0\7e\2\2\u00d0\u00d1\7j\2\2\u00d1\u00d2\7c\2\2\u00d2"+
		"\u00d3\7p\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7n\2\2"+
		"\u00d6\64\3\2\2\2\u00d7\u00d8\7h\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7"+
		"t\2\2\u00da\u00db\7g\2\2\u00db\66\3\2\2\2\u00dc\u00e0\59\35\2\u00dd\u00df"+
		"\5;\36\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e18\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00ea\t\2\2\2"+
		"\u00e4\u00e5\n\3\2\2\u00e5\u00ea\6\35\2\2\u00e6\u00e7\t\4\2\2\u00e7\u00e8"+
		"\t\5\2\2\u00e8\u00ea\6\35\3\2\u00e9\u00e3\3\2\2\2\u00e9\u00e4\3\2\2\2"+
		"\u00e9\u00e6\3\2\2\2\u00ea:\3\2\2\2\u00eb\u00f2\t\6\2\2\u00ec\u00ed\n"+
		"\3\2\2\u00ed\u00f2\6\36\4\2\u00ee\u00ef\t\4\2\2\u00ef\u00f0\t\5\2\2\u00f0"+
		"\u00f2\6\36\5\2\u00f1\u00eb\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f1\u00ee\3"+
		"\2\2\2\u00f2<\3\2\2\2\u00f3\u00f4\t\7\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6"+
		"\b\37\2\2\u00f6>\3\2\2\2\u00f7\u00f8\7\61\2\2\u00f8\u00f9\7,\2\2\u00f9"+
		"\u00fd\3\2\2\2\u00fa\u00fc\13\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3"+
		"\2\2\2\u00fd\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u0100\u0101\7,\2\2\u0101\u0102\7\61\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0104\b \2\2\u0104@\3\2\2\2\u0105\u0106\7\61\2\2\u0106\u0107"+
		"\7\61\2\2\u0107\u010b\3\2\2\2\u0108\u010a\n\b\2\2\u0109\u0108\3\2\2\2"+
		"\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010f"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0110\7\17\2\2\u010f\u010e\3\2\2\2"+
		"\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\7\f\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0114\b!\2\2\u0114B\3\2\2\2\t\2\u00e0\u00e9\u00f1\u00fd"+
		"\u010b\u010f\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}