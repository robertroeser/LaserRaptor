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
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, Request=20, RequestN=21, Subscribe=22, Channel=23, 
		Fire=24, Identifier=25, WS=26, COMMENT=27, LINE_COMMENT=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'boolean'", "'service'", "'long'", "'float'", "'{'", "';'", "'list'", 
		"'byte'", "'}'", "'namespace'", "'short'", "'returns'", "'string'", "'map'", 
		"'double'", "'int'", "'binary'", "'message'", "'.'", "'request'", "'requestN'", 
		"'subscribe'", "'channel'", "'fire'", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", 
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "Request", "RequestN", "Subscribe", "Channel", "Fire", 
		"Identifier", "Letter", "LetterOrDigit", "WS", "COMMENT", "LINE_COMMENT"
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
		case 25: return Letter_sempred((RuleContext)_localctx, predIndex);

		case 26: return LetterOrDigit_sempred((RuleContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u010a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\7\32\u00d4\n\32\f\32"+
		"\16\32\u00d7\13\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00df\n\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u00e7\n\34\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\7\36\u00f1\n\36\f\36\16\36\u00f4\13\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\7\37\u00ff\n\37\f\37\16\37\u0102\13\37\3\37"+
		"\5\37\u0105\n\37\3\37\3\37\3\37\3\37\3\u00f2\2 \3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\2\67\29\34;\35=\36\3\2\t\6\2&&C\\aac|"+
		"\4\2\2\u0101\ud802\udc01\3\2\ud802\udc01\3\2\udc02\ue001\7\2&&\62;C\\"+
		"aac|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u010f\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5G\3\2\2\2\7O\3\2\2\2\t"+
		"T\3\2\2\2\13Z\3\2\2\2\r\\\3\2\2\2\17^\3\2\2\2\21c\3\2\2\2\23h\3\2\2\2"+
		"\25j\3\2\2\2\27t\3\2\2\2\31z\3\2\2\2\33\u0082\3\2\2\2\35\u0089\3\2\2\2"+
		"\37\u008d\3\2\2\2!\u0094\3\2\2\2#\u0098\3\2\2\2%\u009f\3\2\2\2\'\u00a7"+
		"\3\2\2\2)\u00a9\3\2\2\2+\u00b1\3\2\2\2-\u00ba\3\2\2\2/\u00c4\3\2\2\2\61"+
		"\u00cc\3\2\2\2\63\u00d1\3\2\2\2\65\u00de\3\2\2\2\67\u00e6\3\2\2\29\u00e8"+
		"\3\2\2\2;\u00ec\3\2\2\2=\u00fa\3\2\2\2?@\7d\2\2@A\7q\2\2AB\7q\2\2BC\7"+
		"n\2\2CD\7g\2\2DE\7c\2\2EF\7p\2\2F\4\3\2\2\2GH\7u\2\2HI\7g\2\2IJ\7t\2\2"+
		"JK\7x\2\2KL\7k\2\2LM\7e\2\2MN\7g\2\2N\6\3\2\2\2OP\7n\2\2PQ\7q\2\2QR\7"+
		"p\2\2RS\7i\2\2S\b\3\2\2\2TU\7h\2\2UV\7n\2\2VW\7q\2\2WX\7c\2\2XY\7v\2\2"+
		"Y\n\3\2\2\2Z[\7}\2\2[\f\3\2\2\2\\]\7=\2\2]\16\3\2\2\2^_\7n\2\2_`\7k\2"+
		"\2`a\7u\2\2ab\7v\2\2b\20\3\2\2\2cd\7d\2\2de\7{\2\2ef\7v\2\2fg\7g\2\2g"+
		"\22\3\2\2\2hi\7\177\2\2i\24\3\2\2\2jk\7p\2\2kl\7c\2\2lm\7o\2\2mn\7g\2"+
		"\2no\7u\2\2op\7r\2\2pq\7c\2\2qr\7e\2\2rs\7g\2\2s\26\3\2\2\2tu\7u\2\2u"+
		"v\7j\2\2vw\7q\2\2wx\7t\2\2xy\7v\2\2y\30\3\2\2\2z{\7t\2\2{|\7g\2\2|}\7"+
		"v\2\2}~\7w\2\2~\177\7t\2\2\177\u0080\7p\2\2\u0080\u0081\7u\2\2\u0081\32"+
		"\3\2\2\2\u0082\u0083\7u\2\2\u0083\u0084\7v\2\2\u0084\u0085\7t\2\2\u0085"+
		"\u0086\7k\2\2\u0086\u0087\7p\2\2\u0087\u0088\7i\2\2\u0088\34\3\2\2\2\u0089"+
		"\u008a\7o\2\2\u008a\u008b\7c\2\2\u008b\u008c\7r\2\2\u008c\36\3\2\2\2\u008d"+
		"\u008e\7f\2\2\u008e\u008f\7q\2\2\u008f\u0090\7w\2\2\u0090\u0091\7d\2\2"+
		"\u0091\u0092\7n\2\2\u0092\u0093\7g\2\2\u0093 \3\2\2\2\u0094\u0095\7k\2"+
		"\2\u0095\u0096\7p\2\2\u0096\u0097\7v\2\2\u0097\"\3\2\2\2\u0098\u0099\7"+
		"d\2\2\u0099\u009a\7k\2\2\u009a\u009b\7p\2\2\u009b\u009c\7c\2\2\u009c\u009d"+
		"\7t\2\2\u009d\u009e\7{\2\2\u009e$\3\2\2\2\u009f\u00a0\7o\2\2\u00a0\u00a1"+
		"\7g\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7c\2\2\u00a4"+
		"\u00a5\7i\2\2\u00a5\u00a6\7g\2\2\u00a6&\3\2\2\2\u00a7\u00a8\7\60\2\2\u00a8"+
		"(\3\2\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7s\2\2\u00ac"+
		"\u00ad\7w\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7v\2\2"+
		"\u00b0*\3\2\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7s\2"+
		"\2\u00b4\u00b5\7w\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8"+
		"\7v\2\2\u00b8\u00b9\7P\2\2\u00b9,\3\2\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc"+
		"\7w\2\2\u00bc\u00bd\7d\2\2\u00bd\u00be\7u\2\2\u00be\u00bf\7e\2\2\u00bf"+
		"\u00c0\7t\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7d\2\2\u00c2\u00c3\7g\2\2"+
		"\u00c3.\3\2\2\2\u00c4\u00c5\7e\2\2\u00c5\u00c6\7j\2\2\u00c6\u00c7\7c\2"+
		"\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb"+
		"\7n\2\2\u00cb\60\3\2\2\2\u00cc\u00cd\7h\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf"+
		"\7t\2\2\u00cf\u00d0\7g\2\2\u00d0\62\3\2\2\2\u00d1\u00d5\5\65\33\2\u00d2"+
		"\u00d4\5\67\34\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3"+
		"\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\64\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8"+
		"\u00df\t\2\2\2\u00d9\u00da\n\3\2\2\u00da\u00df\6\33\2\2\u00db\u00dc\t"+
		"\4\2\2\u00dc\u00dd\t\5\2\2\u00dd\u00df\6\33\3\2\u00de\u00d8\3\2\2\2\u00de"+
		"\u00d9\3\2\2\2\u00de\u00db\3\2\2\2\u00df\66\3\2\2\2\u00e0\u00e7\t\6\2"+
		"\2\u00e1\u00e2\n\3\2\2\u00e2\u00e7\6\34\4\2\u00e3\u00e4\t\4\2\2\u00e4"+
		"\u00e5\t\5\2\2\u00e5\u00e7\6\34\5\2\u00e6\u00e0\3\2\2\2\u00e6\u00e1\3"+
		"\2\2\2\u00e6\u00e3\3\2\2\2\u00e78\3\2\2\2\u00e8\u00e9\t\7\2\2\u00e9\u00ea"+
		"\3\2\2\2\u00ea\u00eb\b\35\2\2\u00eb:\3\2\2\2\u00ec\u00ed\7\61\2\2\u00ed"+
		"\u00ee\7,\2\2\u00ee\u00f2\3\2\2\2\u00ef\u00f1\13\2\2\2\u00f0\u00ef\3\2"+
		"\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7,\2\2\u00f6\u00f7\7\61"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\b\36\2\2\u00f9<\3\2\2\2\u00fa\u00fb"+
		"\7\61\2\2\u00fb\u00fc\7\61\2\2\u00fc\u0100\3\2\2\2\u00fd\u00ff\n\b\2\2"+
		"\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0105\7\17\2\2"+
		"\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107"+
		"\7\f\2\2\u0107\u0108\3\2\2\2\u0108\u0109\b\37\2\2\u0109>\3\2\2\2\t\2\u00d5"+
		"\u00de\u00e6\u00f2\u0100\u0104\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}