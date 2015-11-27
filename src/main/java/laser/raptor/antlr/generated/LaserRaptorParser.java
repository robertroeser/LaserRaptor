// Generated from /Users/rroeser/projects/LaserRaptor/src/main/antlr4/LaserRaptor.g4 by ANTLR 4.2.2

package laser.raptor.antlr.generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LaserRaptorParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__15=1, T__14=2, T__13=3, T__12=4, T__11=5, T__10=6, T__9=7, T__8=8, 
		T__7=9, T__6=10, T__5=11, T__4=12, T__3=13, T__2=14, T__1=15, T__0=16, 
		Identifier=17, WS=18, COMMENT=19, LINE_COMMENT=20;
	public static final String[] tokenNames = {
		"<INVALID>", "'long'", "'float'", "'{'", "';'", "'list'", "'byte'", "'}'", 
		"'namespace'", "'short'", "'string'", "'map'", "'double'", "'int'", "'binary'", 
		"'message'", "'.'", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_laserRaptor = 0, RULE_namespaceDeclaration = 1, RULE_messageDeclaration = 2, 
		RULE_messageBody = 3, RULE_messageBodyDeclaration = 4, RULE_fieldDeclaration = 5, 
		RULE_type = 6, RULE_messageType = 7, RULE_qualifiedName = 8;
	public static final String[] ruleNames = {
		"laserRaptor", "namespaceDeclaration", "messageDeclaration", "messageBody", 
		"messageBodyDeclaration", "fieldDeclaration", "type", "messageType", "qualifiedName"
	};

	@Override
	public String getGrammarFileName() { return "LaserRaptor.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LaserRaptorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LaserRaptorContext extends ParserRuleContext {
		public List<MessageDeclarationContext> messageDeclaration() {
			return getRuleContexts(MessageDeclarationContext.class);
		}
		public NamespaceDeclarationContext namespaceDeclaration() {
			return getRuleContext(NamespaceDeclarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LaserRaptorParser.EOF, 0); }
		public MessageDeclarationContext messageDeclaration(int i) {
			return getRuleContext(MessageDeclarationContext.class,i);
		}
		public LaserRaptorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_laserRaptor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterLaserRaptor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitLaserRaptor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitLaserRaptor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LaserRaptorContext laserRaptor() throws RecognitionException {
		LaserRaptorContext _localctx = new LaserRaptorContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_laserRaptor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_la = _input.LA(1);
			if (_la==8) {
				{
				setState(18); namespaceDeclaration();
				}
			}

			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==15) {
				{
				{
				setState(21); messageDeclaration();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespaceDeclarationContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public NamespaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterNamespaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitNamespaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitNamespaceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceDeclarationContext namespaceDeclaration() throws RecognitionException {
		NamespaceDeclarationContext _localctx = new NamespaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_namespaceDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); match(8);
			setState(30); qualifiedName();
			setState(31); match(4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LaserRaptorParser.Identifier, 0); }
		public MessageBodyContext messageBody() {
			return getRuleContext(MessageBodyContext.class,0);
		}
		public MessageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterMessageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitMessageDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitMessageDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageDeclarationContext messageDeclaration() throws RecognitionException {
		MessageDeclarationContext _localctx = new MessageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_messageDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); match(15);
			setState(34); match(Identifier);
			setState(35); messageBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageBodyContext extends ParserRuleContext {
		public MessageBodyDeclarationContext messageBodyDeclaration(int i) {
			return getRuleContext(MessageBodyDeclarationContext.class,i);
		}
		public List<MessageBodyDeclarationContext> messageBodyDeclaration() {
			return getRuleContexts(MessageBodyDeclarationContext.class);
		}
		public MessageBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterMessageBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitMessageBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitMessageBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageBodyContext messageBody() throws RecognitionException {
		MessageBodyContext _localctx = new MessageBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_messageBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); match(3);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 4) | (1L << 5) | (1L << 6) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << Identifier))) != 0)) {
				{
				{
				setState(38); messageBodyDeclaration();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44); match(7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageBodyDeclarationContext extends ParserRuleContext {
		public MessageDeclarationContext messageDeclaration() {
			return getRuleContext(MessageDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public MessageBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterMessageBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitMessageBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitMessageBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageBodyDeclarationContext messageBodyDeclaration() throws RecognitionException {
		MessageBodyDeclarationContext _localctx = new MessageBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_messageBodyDeclaration);
		try {
			setState(49);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(46); match(4);
				}
				break;
			case 1:
			case 2:
			case 5:
			case 6:
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(47); fieldDeclaration();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 3);
				{
				setState(48); messageDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LaserRaptorParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); type();
			setState(52); match(Identifier);
			setState(53); match(4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public MessageTypeContext messageType(int i) {
			return getRuleContext(MessageTypeContext.class,i);
		}
		public List<MessageTypeContext> messageType() {
			return getRuleContexts(MessageTypeContext.class);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 5) | (1L << 6) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14))) != 0)) {
				{
				{
				setState(55); messageType();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageTypeContext extends ParserRuleContext {
		public MessageTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterMessageType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitMessageType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitMessageType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageTypeContext messageType() throws RecognitionException {
		MessageTypeContext _localctx = new MessageTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_messageType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 5) | (1L << 6) | (1L << 9) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 13) | (1L << 14))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(LaserRaptorParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(LaserRaptorParser.Identifier, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); match(Identifier);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==16) {
				{
				{
				setState(64); match(16);
				setState(65); match(Identifier);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26J\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\5\2\26"+
		"\n\2\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\7\5*\n\5\f\5\16\5-\13\5\3\5\3\5\3\6\3\6\3\6\5\6\64\n\6"+
		"\3\7\3\7\3\7\3\7\3\b\7\b;\n\b\f\b\16\b>\13\b\3\t\3\t\3\n\3\n\3\n\7\nE"+
		"\n\n\f\n\16\nH\13\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\3\5\2\3\4\7\b\13"+
		"\20G\2\25\3\2\2\2\4\37\3\2\2\2\6#\3\2\2\2\b\'\3\2\2\2\n\63\3\2\2\2\f\65"+
		"\3\2\2\2\16<\3\2\2\2\20?\3\2\2\2\22A\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2"+
		"\2\25\26\3\2\2\2\26\32\3\2\2\2\27\31\5\6\4\2\30\27\3\2\2\2\31\34\3\2\2"+
		"\2\32\30\3\2\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\32\3\2\2\2\35\36\7\2\2"+
		"\3\36\3\3\2\2\2\37 \7\n\2\2 !\5\22\n\2!\"\7\6\2\2\"\5\3\2\2\2#$\7\21\2"+
		"\2$%\7\23\2\2%&\5\b\5\2&\7\3\2\2\2\'+\7\5\2\2(*\5\n\6\2)(\3\2\2\2*-\3"+
		"\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\t\2\2/\t\3\2\2\2\60"+
		"\64\7\6\2\2\61\64\5\f\7\2\62\64\5\6\4\2\63\60\3\2\2\2\63\61\3\2\2\2\63"+
		"\62\3\2\2\2\64\13\3\2\2\2\65\66\5\16\b\2\66\67\7\23\2\2\678\7\6\2\28\r"+
		"\3\2\2\29;\5\20\t\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\17\3\2\2"+
		"\2><\3\2\2\2?@\t\2\2\2@\21\3\2\2\2AF\7\23\2\2BC\7\22\2\2CE\7\23\2\2DB"+
		"\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\23\3\2\2\2HF\3\2\2\2\b\25\32+"+
		"\63<F";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}