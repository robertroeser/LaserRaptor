// Generated from /Users/rroeser/projects/LaserRaptor/src/main/antlr4/LaserRaptor.g4 by ANTLR 4.2.2

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
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, Request=19, RequestN=20, Subscribe=21, Channel=22, Fire=23, 
		Identifier=24, WS=25, COMMENT=26, LINE_COMMENT=27;
	public static final String[] tokenNames = {
		"<INVALID>", "'service'", "'long'", "'float'", "'{'", "';'", "'list'", 
		"'byte'", "'}'", "'namespace'", "'short'", "'returns'", "'string'", "'map'", 
		"'double'", "'int'", "'binary'", "'message'", "'.'", "'request'", "'requestN'", 
		"'subscribe'", "'channel'", "'fire'", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
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
		public List<ServiceDeclarationContext> serviceDeclaration() {
			return getRuleContexts(ServiceDeclarationContext.class);
		}
		public ServiceDeclarationContext serviceDeclaration(int i) {
			return getRuleContext(ServiceDeclarationContext.class,i);
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
			if (_la==9) {
				{
				setState(24); namespaceDeclaration();
				}
			}

			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==17) {
				{
				{
				setState(27); messageDeclaration();
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(33); serviceDeclaration();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39); match(EOF);
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
			setState(41); match(9);
			setState(42); qualifiedName();
			setState(43); match(5);
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
			setState(45); match(17);
			setState(46); match(Identifier);
			setState(47); messageBody();
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
			setState(49); match(4);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 5) | (1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 17) | (1L << Identifier))) != 0)) {
				{
				{
				setState(50); messageBodyDeclaration();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56); match(8);
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
			setState(61);
			switch (_input.LA(1)) {
			case 5:
				enterOuterAlt(_localctx, 1);
				{
				setState(58); match(5);
				}
				break;
			case 2:
			case 3:
			case 6:
			case 7:
			case 10:
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(59); fieldDeclaration();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 3);
				{
				setState(60); messageDeclaration();
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
			setState(65); match(5);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16))) != 0)) {
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 3) | (1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 13) | (1L << 14) | (1L << 15) | (1L << 16))) != 0)) ) {
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
			setState(75); match(1);
			setState(76); match(Identifier);
			setState(77); serviceBody();
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
			setState(79); match(4);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Request) | (1L << RequestN) | (1L << Subscribe) | (1L << Channel) | (1L << Fire))) != 0)) {
				{
				{
				setState(80); serviceBodyDeclaration();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86); match(8);
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
			setState(118);
			switch (_input.LA(1)) {
			case Request:
				enterOuterAlt(_localctx, 1);
				{
				setState(88); match(Request);
				setState(89); match(Identifier);
				setState(90); match(Identifier);
				setState(91); match(11);
				setState(92); match(Identifier);
				setState(93); match(5);
				}
				break;
			case RequestN:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); match(RequestN);
				setState(95); match(Identifier);
				setState(96); match(Identifier);
				setState(97); match(11);
				setState(98); match(Identifier);
				setState(99); match(5);
				}
				break;
			case Subscribe:
				enterOuterAlt(_localctx, 3);
				{
				setState(100); match(Subscribe);
				setState(101); match(Identifier);
				setState(102); match(Identifier);
				setState(103); match(11);
				setState(104); match(Identifier);
				setState(105); match(5);
				}
				break;
			case Channel:
				enterOuterAlt(_localctx, 4);
				{
				setState(106); match(Channel);
				setState(107); match(Identifier);
				setState(108); match(Identifier);
				setState(109); match(11);
				setState(110); match(Identifier);
				setState(111); match(5);
				}
				break;
			case Fire:
				enterOuterAlt(_localctx, 5);
				{
				setState(112); match(Fire);
				setState(113); match(Identifier);
				setState(114); match(Identifier);
				setState(115); match(11);
				setState(116); match(Identifier);
				setState(117); match(5);
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
			setState(120); match(Identifier);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==18) {
				{
				{
				setState(121); match(18);
				setState(122); match(Identifier);
				}
				}
				setState(127);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u0083\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\5\2\34\n\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3"+
		"\2\7\2%\n\2\f\2\16\2(\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\7\5\66\n\5\f\5\16\59\13\5\3\5\3\5\3\6\3\6\3\6\5\6@\n\6\3\7\3\7\3"+
		"\7\3\7\3\b\7\bG\n\b\f\b\16\bJ\13\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\7"+
		"\13T\n\13\f\13\16\13W\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\fy\n\f\3\r\3\r\3\r\7\r~\n\r\f\r\16\r\u0081\13\r\3"+
		"\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\6\2\4\5\b\t\f\f\16\22\u0083"+
		"\2\33\3\2\2\2\4+\3\2\2\2\6/\3\2\2\2\b\63\3\2\2\2\n?\3\2\2\2\fA\3\2\2\2"+
		"\16H\3\2\2\2\20K\3\2\2\2\22M\3\2\2\2\24Q\3\2\2\2\26x\3\2\2\2\30z\3\2\2"+
		"\2\32\34\5\4\3\2\33\32\3\2\2\2\33\34\3\2\2\2\34 \3\2\2\2\35\37\5\6\4\2"+
		"\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!&\3\2\2\2\" \3\2\2\2"+
		"#%\5\22\n\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2"+
		"\2\2)*\7\2\2\3*\3\3\2\2\2+,\7\13\2\2,-\5\30\r\2-.\7\7\2\2.\5\3\2\2\2/"+
		"\60\7\23\2\2\60\61\7\32\2\2\61\62\5\b\5\2\62\7\3\2\2\2\63\67\7\6\2\2\64"+
		"\66\5\n\6\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2"+
		"\2\29\67\3\2\2\2:;\7\n\2\2;\t\3\2\2\2<@\7\7\2\2=@\5\f\7\2>@\5\6\4\2?<"+
		"\3\2\2\2?=\3\2\2\2?>\3\2\2\2@\13\3\2\2\2AB\5\16\b\2BC\7\32\2\2CD\7\7\2"+
		"\2D\r\3\2\2\2EG\5\20\t\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\17\3"+
		"\2\2\2JH\3\2\2\2KL\t\2\2\2L\21\3\2\2\2MN\7\3\2\2NO\7\32\2\2OP\5\24\13"+
		"\2P\23\3\2\2\2QU\7\6\2\2RT\5\26\f\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3"+
		"\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7\n\2\2Y\25\3\2\2\2Z[\7\25\2\2[\\\7\32\2"+
		"\2\\]\7\32\2\2]^\7\r\2\2^_\7\32\2\2_y\7\7\2\2`a\7\26\2\2ab\7\32\2\2bc"+
		"\7\32\2\2cd\7\r\2\2de\7\32\2\2ey\7\7\2\2fg\7\27\2\2gh\7\32\2\2hi\7\32"+
		"\2\2ij\7\r\2\2jk\7\32\2\2ky\7\7\2\2lm\7\30\2\2mn\7\32\2\2no\7\32\2\2o"+
		"p\7\r\2\2pq\7\32\2\2qy\7\7\2\2rs\7\31\2\2st\7\32\2\2tu\7\32\2\2uv\7\r"+
		"\2\2vw\7\32\2\2wy\7\7\2\2xZ\3\2\2\2x`\3\2\2\2xf\3\2\2\2xl\3\2\2\2xr\3"+
		"\2\2\2y\27\3\2\2\2z\177\7\32\2\2{|\7\24\2\2|~\7\32\2\2}{\3\2\2\2~\u0081"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\31\3\2\2\2\u0081\177\3\2"+
		"\2\2\13\33 &\67?HUx\177";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}