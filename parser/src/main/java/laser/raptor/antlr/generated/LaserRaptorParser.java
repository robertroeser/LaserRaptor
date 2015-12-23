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
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, Request=20, RequestN=21, Subscribe=22, Channel=23, 
		Fire=24, Identifier=25, WS=26, COMMENT=27, LINE_COMMENT=28;
	public static final String[] tokenNames = {
		"<INVALID>", "'boolean'", "'service'", "'long'", "'float'", "'{'", "';'", 
		"'list'", "'byte'", "'}'", "'namespace'", "'short'", "'returns'", "'string'", 
		"'map'", "'double'", "'int'", "'binary'", "'message'", "'.'", "'request'", 
		"'requestN'", "'subscribe'", "'channel'", "'fire'", "Identifier", "WS", 
		"COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_laserRaptor = 0, RULE_namespaceDeclaration = 1, RULE_messageDeclaration = 2, 
		RULE_messageBody = 3, RULE_messageBodyDeclaration = 4, RULE_fieldDeclaration = 5, 
		RULE_type = 6, RULE_messageType = 7, RULE_serviceDeclaration = 8, RULE_serviceBody = 9, 
		RULE_serviceBodyDeclaration = 10, RULE_qualifiedName = 11;
	public static final String[] ruleNames = {
		"laserRaptor", "namespaceDeclaration", "messageDeclaration", "messageBody", 
		"messageBodyDeclaration", "fieldDeclaration", "type", "messageType", "serviceDeclaration", 
		"serviceBody", "serviceBodyDeclaration", "qualifiedName"
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
			setState(25);
			_la = _input.LA(1);
			if (_la==10) {
				{
				setState(24); namespaceDeclaration();
				}
			}

			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==18) {
				{
				{
				setState(27); messageDeclaration();
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33); serviceDeclaration();
			setState(34); match(EOF);
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
			setState(36); match(10);
			setState(37); qualifiedName();
			setState(38); match(6);
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
			setState(40); match(18);
			setState(41); match(Identifier);
			setState(42); messageBody();
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
			setState(44); match(5);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 6) | (1L << 7) | (1L << 8) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << 18) | (1L << Identifier))) != 0)) {
				{
				{
				setState(45); messageBodyDeclaration();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51); match(9);
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
			setState(56);
			switch (_input.LA(1)) {
			case 6:
				enterOuterAlt(_localctx, 1);
				{
				setState(53); match(6);
				}
				break;
			case 1:
			case 3:
			case 4:
			case 7:
			case 8:
			case 11:
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(54); fieldDeclaration();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 3);
				{
				setState(55); messageDeclaration();
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
			setState(58); type();
			setState(59); match(Identifier);
			setState(60); match(6);
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
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 7) | (1L << 8) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17))) != 0)) {
				{
				{
				setState(62); messageType();
				}
				}
				setState(67);
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
			setState(68);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 4) | (1L << 7) | (1L << 8) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17))) != 0)) ) {
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
		enterRule(_localctx, 16, RULE_serviceDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); match(2);
			setState(71); match(Identifier);
			setState(72); serviceBody();
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
		enterRule(_localctx, 18, RULE_serviceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); match(5);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Request) | (1L << RequestN) | (1L << Subscribe) | (1L << Channel) | (1L << Fire))) != 0)) {
				{
				{
				setState(75); serviceBodyDeclaration();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81); match(9);
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
		enterRule(_localctx, 20, RULE_serviceBodyDeclaration);
		try {
			setState(111);
			switch (_input.LA(1)) {
			case Request:
				enterOuterAlt(_localctx, 1);
				{
				setState(83); match(Request);
				setState(84); match(Identifier);
				setState(85); match(Identifier);
				setState(86); match(12);
				setState(87); match(Identifier);
				setState(88); match(6);
				}
				break;
			case RequestN:
				enterOuterAlt(_localctx, 2);
				{
				setState(89); match(RequestN);
				setState(90); match(Identifier);
				setState(91); match(Identifier);
				setState(92); match(12);
				setState(93); match(Identifier);
				setState(94); match(6);
				}
				break;
			case Subscribe:
				enterOuterAlt(_localctx, 3);
				{
				setState(95); match(Subscribe);
				setState(96); match(Identifier);
				setState(97); match(Identifier);
				setState(98); match(12);
				setState(99); match(Identifier);
				setState(100); match(6);
				}
				break;
			case Channel:
				enterOuterAlt(_localctx, 4);
				{
				setState(101); match(Channel);
				setState(102); match(Identifier);
				setState(103); match(Identifier);
				setState(104); match(12);
				setState(105); match(Identifier);
				setState(106); match(6);
				}
				break;
			case Fire:
				enterOuterAlt(_localctx, 5);
				{
				setState(107); match(Fire);
				setState(108); match(Identifier);
				setState(109); match(Identifier);
				setState(110); match(6);
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
		enterRule(_localctx, 22, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(Identifier);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==19) {
				{
				{
				setState(114); match(19);
				setState(115); match(Identifier);
				}
				}
				setState(120);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36|\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\5\2\34\n\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\7\5\61\n\5\f\5\16\5\64\13\5"+
		"\3\5\3\5\3\6\3\6\3\6\5\6;\n\6\3\7\3\7\3\7\3\7\3\b\7\bB\n\b\f\b\16\bE\13"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\7\13O\n\13\f\13\16\13R\13\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fr\n\f\3\r\3\r\3\r"+
		"\7\rw\n\r\f\r\16\rz\13\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3"+
		"\7\2\3\3\5\6\t\n\r\r\17\23{\2\33\3\2\2\2\4&\3\2\2\2\6*\3\2\2\2\b.\3\2"+
		"\2\2\n:\3\2\2\2\f<\3\2\2\2\16C\3\2\2\2\20F\3\2\2\2\22H\3\2\2\2\24L\3\2"+
		"\2\2\26q\3\2\2\2\30s\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\33\34\3\2\2\2"+
		"\34 \3\2\2\2\35\37\5\6\4\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3"+
		"\2\2\2!#\3\2\2\2\" \3\2\2\2#$\5\22\n\2$%\7\2\2\3%\3\3\2\2\2&\'\7\f\2\2"+
		"\'(\5\30\r\2()\7\b\2\2)\5\3\2\2\2*+\7\24\2\2+,\7\33\2\2,-\5\b\5\2-\7\3"+
		"\2\2\2.\62\7\7\2\2/\61\5\n\6\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2"+
		"\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\7\13\2\2\66\t\3\2\2\2"+
		"\67;\7\b\2\28;\5\f\7\29;\5\6\4\2:\67\3\2\2\2:8\3\2\2\2:9\3\2\2\2;\13\3"+
		"\2\2\2<=\5\16\b\2=>\7\33\2\2>?\7\b\2\2?\r\3\2\2\2@B\5\20\t\2A@\3\2\2\2"+
		"BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\17\3\2\2\2EC\3\2\2\2FG\t\2\2\2G\21\3\2"+
		"\2\2HI\7\4\2\2IJ\7\33\2\2JK\5\24\13\2K\23\3\2\2\2LP\7\7\2\2MO\5\26\f\2"+
		"NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2ST\7\13\2"+
		"\2T\25\3\2\2\2UV\7\26\2\2VW\7\33\2\2WX\7\33\2\2XY\7\16\2\2YZ\7\33\2\2"+
		"Zr\7\b\2\2[\\\7\27\2\2\\]\7\33\2\2]^\7\33\2\2^_\7\16\2\2_`\7\33\2\2`r"+
		"\7\b\2\2ab\7\30\2\2bc\7\33\2\2cd\7\33\2\2de\7\16\2\2ef\7\33\2\2fr\7\b"+
		"\2\2gh\7\31\2\2hi\7\33\2\2ij\7\33\2\2jk\7\16\2\2kl\7\33\2\2lr\7\b\2\2"+
		"mn\7\32\2\2no\7\33\2\2op\7\33\2\2pr\7\b\2\2qU\3\2\2\2q[\3\2\2\2qa\3\2"+
		"\2\2qg\3\2\2\2qm\3\2\2\2r\27\3\2\2\2sx\7\33\2\2tu\7\25\2\2uw\7\33\2\2"+
		"vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\31\3\2\2\2zx\3\2\2\2\n\33 \62"+
		":CPqx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}