// Generated from /Users/rroeser/projects/LaserRaptor/parser/src/main/antlr4/LaserRaptor.g4 by ANTLR 4.2.2

package laser.raptor.antlr.generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LaserRaptorParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__20=1, T__19=2, T__18=3, T__17=4, T__16=5, T__15=6, T__14=7, T__13=8, 
		T__12=9, T__11=10, T__10=11, T__9=12, T__8=13, T__7=14, T__6=15, T__5=16, 
		T__4=17, T__3=18, T__2=19, T__1=20, T__0=21, Request=22, RequestN=23, 
		Subscribe=24, Channel=25, Fire=26, Identifier=27, WS=28, COMMENT=29, LINE_COMMENT=30;
	public static final String[] tokenNames = {
		"<INVALID>", "'boolean'", "'service'", "'long'", "'float'", "'{'", "';'", 
		"'list'", "'byte'", "'}'", "'enum'", "'namespace'", "'short'", "'returns'", 
		"'string'", "'map'", "'double'", "'int'", "'binary'", "'message'", "','", 
		"'.'", "'request'", "'requestN'", "'subscribe'", "'channel'", "'fire'", 
		"Identifier", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_laserRaptor = 0, RULE_namespaceDeclaration = 1, RULE_messageDeclaration = 2, 
		RULE_messageBody = 3, RULE_messageBodyDeclaration = 4, RULE_fieldDeclaration = 5, 
		RULE_type = 6, RULE_messageType = 7, RULE_enumDeclaration = 8, RULE_enumBody = 9, 
		RULE_serviceDeclaration = 10, RULE_serviceBody = 11, RULE_serviceBodyDeclaration = 12, 
		RULE_qualifiedName = 13;
	public static final String[] ruleNames = {
		"laserRaptor", "namespaceDeclaration", "messageDeclaration", "messageBody", 
		"messageBodyDeclaration", "fieldDeclaration", "type", "messageType", "enumDeclaration", 
		"enumBody", "serviceDeclaration", "serviceBody", "serviceBodyDeclaration", 
		"qualifiedName"
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
		public ServiceDeclarationContext serviceDeclaration() {
			return getRuleContext(ServiceDeclarationContext.class,0);
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
			setState(29);
			_la = _input.LA(1);
			if (_la==11) {
				{
				setState(28); namespaceDeclaration();
				}
			}

			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==19) {
				{
				{
				setState(31); messageDeclaration();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37); serviceDeclaration();
			setState(38); match(EOF);
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
			setState(40); match(11);
			setState(41); qualifiedName();
			setState(42); match(6);
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
			setState(44); match(19);
			setState(45); match(Identifier);
			setState(46); messageBody();
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
			setState(48); match(5);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << 19) | (1L << Identifier))) != 0)) {
				{
				{
				setState(49); messageBodyDeclaration();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55); match(9);
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
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
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
			setState(61);
			switch (_input.LA(1)) {
			case 6:
				enterOuterAlt(_localctx, 1);
				{
				setState(57); match(6);
				}
				break;
			case 1:
			case 3:
			case 4:
			case 7:
			case 8:
			case 12:
			case 14:
			case 15:
			case 16:
			case 17:
			case 18:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(58); fieldDeclaration();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 3);
				{
				setState(59); messageDeclaration();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 4);
				{
				setState(60); enumDeclaration();
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
			setState(63); type();
			setState(64); match(Identifier);
			setState(65); match(6);
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
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 7) | (1L << 8) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18))) != 0)) {
				{
				{
				setState(67); messageType();
				}
				}
				setState(72);
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
			setState(73);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 7) | (1L << 8) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18))) != 0)) ) {
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

	public static class EnumDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LaserRaptorParser.Identifier, 0); }
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitEnumDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitEnumDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_enumDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); match(10);
			setState(76); match(Identifier);
			setState(77); enumBody();
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

	public static class EnumBodyContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(LaserRaptorParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(LaserRaptorParser.Identifier, i);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitEnumBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitEnumBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); match(5);
			setState(80); match(Identifier);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==20) {
				{
				{
				setState(81); match(20);
				setState(82); match(Identifier);
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88); match(9);
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

	public static class ServiceDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(LaserRaptorParser.Identifier, 0); }
		public ServiceBodyContext serviceBody() {
			return getRuleContext(ServiceBodyContext.class,0);
		}
		public ServiceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterServiceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitServiceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitServiceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceDeclarationContext serviceDeclaration() throws RecognitionException {
		ServiceDeclarationContext _localctx = new ServiceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_serviceDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); match(2);
			setState(91); match(Identifier);
			setState(92); serviceBody();
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

	public static class ServiceBodyContext extends ParserRuleContext {
		public ServiceBodyDeclarationContext serviceBodyDeclaration(int i) {
			return getRuleContext(ServiceBodyDeclarationContext.class,i);
		}
		public List<ServiceBodyDeclarationContext> serviceBodyDeclaration() {
			return getRuleContexts(ServiceBodyDeclarationContext.class);
		}
		public ServiceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterServiceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitServiceBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitServiceBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceBodyContext serviceBody() throws RecognitionException {
		ServiceBodyContext _localctx = new ServiceBodyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_serviceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); match(5);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Request) | (1L << RequestN) | (1L << Subscribe) | (1L << Channel) | (1L << Fire))) != 0)) {
				{
				{
				setState(95); serviceBodyDeclaration();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101); match(9);
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

	public static class ServiceBodyDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(LaserRaptorParser.Identifier); }
		public TerminalNode Request() { return getToken(LaserRaptorParser.Request, 0); }
		public TerminalNode Subscribe() { return getToken(LaserRaptorParser.Subscribe, 0); }
		public TerminalNode Identifier(int i) {
			return getToken(LaserRaptorParser.Identifier, i);
		}
		public TerminalNode Channel() { return getToken(LaserRaptorParser.Channel, 0); }
		public TerminalNode Fire() { return getToken(LaserRaptorParser.Fire, 0); }
		public TerminalNode RequestN() { return getToken(LaserRaptorParser.RequestN, 0); }
		public ServiceBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterServiceBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitServiceBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitServiceBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceBodyDeclarationContext serviceBodyDeclaration() throws RecognitionException {
		ServiceBodyDeclarationContext _localctx = new ServiceBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_serviceBodyDeclaration);
		try {
			setState(131);
			switch (_input.LA(1)) {
			case Request:
				enterOuterAlt(_localctx, 1);
				{
				setState(103); match(Request);
				setState(104); match(Identifier);
				setState(105); match(Identifier);
				setState(106); match(13);
				setState(107); match(Identifier);
				setState(108); match(6);
				}
				break;
			case RequestN:
				enterOuterAlt(_localctx, 2);
				{
				setState(109); match(RequestN);
				setState(110); match(Identifier);
				setState(111); match(Identifier);
				setState(112); match(13);
				setState(113); match(Identifier);
				setState(114); match(6);
				}
				break;
			case Subscribe:
				enterOuterAlt(_localctx, 3);
				{
				setState(115); match(Subscribe);
				setState(116); match(Identifier);
				setState(117); match(Identifier);
				setState(118); match(13);
				setState(119); match(Identifier);
				setState(120); match(6);
				}
				break;
			case Channel:
				enterOuterAlt(_localctx, 4);
				{
				setState(121); match(Channel);
				setState(122); match(Identifier);
				setState(123); match(Identifier);
				setState(124); match(13);
				setState(125); match(Identifier);
				setState(126); match(6);
				}
				break;
			case Fire:
				enterOuterAlt(_localctx, 5);
				{
				setState(127); match(Fire);
				setState(128); match(Identifier);
				setState(129); match(Identifier);
				setState(130); match(6);
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
		enterRule(_localctx, 26, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); match(Identifier);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==21) {
				{
				{
				setState(134); match(21);
				setState(135); match(Identifier);
				}
				}
				setState(140);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 \u0090\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\5\2 \n\2\3\2\7\2#\n\2\f\2"+
		"\16\2&\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\7\5\65"+
		"\n\5\f\5\16\58\13\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6@\n\6\3\7\3\7\3\7\3\7\3"+
		"\b\7\bG\n\b\f\b\16\bJ\13\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\7\13V\n\13\f\13\16\13Y\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\7\rc\n"+
		"\r\f\r\16\rf\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\5\16\u0086\n\16\3\17\3\17\3\17\7\17\u008b\n"+
		"\17\f\17\16\17\u008e\13\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\2\3\7\2\3\3\5\6\t\n\16\16\20\24\u008f\2\37\3\2\2\2\4*\3\2\2\2\6.\3"+
		"\2\2\2\b\62\3\2\2\2\n?\3\2\2\2\fA\3\2\2\2\16H\3\2\2\2\20K\3\2\2\2\22M"+
		"\3\2\2\2\24Q\3\2\2\2\26\\\3\2\2\2\30`\3\2\2\2\32\u0085\3\2\2\2\34\u0087"+
		"\3\2\2\2\36 \5\4\3\2\37\36\3\2\2\2\37 \3\2\2\2 $\3\2\2\2!#\5\6\4\2\"!"+
		"\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\5\26\f"+
		"\2()\7\2\2\3)\3\3\2\2\2*+\7\r\2\2+,\5\34\17\2,-\7\b\2\2-\5\3\2\2\2./\7"+
		"\25\2\2/\60\7\35\2\2\60\61\5\b\5\2\61\7\3\2\2\2\62\66\7\7\2\2\63\65\5"+
		"\n\6\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2"+
		"\28\66\3\2\2\29:\7\13\2\2:\t\3\2\2\2;@\7\b\2\2<@\5\f\7\2=@\5\6\4\2>@\5"+
		"\22\n\2?;\3\2\2\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@\13\3\2\2\2AB\5\16\b\2"+
		"BC\7\35\2\2CD\7\b\2\2D\r\3\2\2\2EG\5\20\t\2FE\3\2\2\2GJ\3\2\2\2HF\3\2"+
		"\2\2HI\3\2\2\2I\17\3\2\2\2JH\3\2\2\2KL\t\2\2\2L\21\3\2\2\2MN\7\f\2\2N"+
		"O\7\35\2\2OP\5\24\13\2P\23\3\2\2\2QR\7\7\2\2RW\7\35\2\2ST\7\26\2\2TV\7"+
		"\35\2\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z["+
		"\7\13\2\2[\25\3\2\2\2\\]\7\4\2\2]^\7\35\2\2^_\5\30\r\2_\27\3\2\2\2`d\7"+
		"\7\2\2ac\5\32\16\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2f"+
		"d\3\2\2\2gh\7\13\2\2h\31\3\2\2\2ij\7\30\2\2jk\7\35\2\2kl\7\35\2\2lm\7"+
		"\17\2\2mn\7\35\2\2n\u0086\7\b\2\2op\7\31\2\2pq\7\35\2\2qr\7\35\2\2rs\7"+
		"\17\2\2st\7\35\2\2t\u0086\7\b\2\2uv\7\32\2\2vw\7\35\2\2wx\7\35\2\2xy\7"+
		"\17\2\2yz\7\35\2\2z\u0086\7\b\2\2{|\7\33\2\2|}\7\35\2\2}~\7\35\2\2~\177"+
		"\7\17\2\2\177\u0080\7\35\2\2\u0080\u0086\7\b\2\2\u0081\u0082\7\34\2\2"+
		"\u0082\u0083\7\35\2\2\u0083\u0084\7\35\2\2\u0084\u0086\7\b\2\2\u0085i"+
		"\3\2\2\2\u0085o\3\2\2\2\u0085u\3\2\2\2\u0085{\3\2\2\2\u0085\u0081\3\2"+
		"\2\2\u0086\33\3\2\2\2\u0087\u008c\7\35\2\2\u0088\u0089\7\27\2\2\u0089"+
		"\u008b\7\35\2\2\u008a\u0088\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008d\35\3\2\2\2\u008e\u008c\3\2\2\2\13\37"+
		"$\66?HWd\u0085\u008c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}