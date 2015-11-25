// Generated from /Users/rroeser/projects/LaserRaptor/src/main/antlr4/LaserRaptor.g4 by ANTLR 4.2.2

package laser.raptor.antlr;

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
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, NAMESPACE=6, MESSAGE=7, MESSAGE_TYPE=8, 
		SERVICE=9, RETURNS=10, SEMI_COLON=11, L_CURLY=12, R_CURLY=13, L_PAREN=14, 
		R_PAREN=15, IDENTIFIER=16, QUALIFIED_IDENTIFIER=17, WS=18, COMMENT=19, 
		LINE_COMMENT=20;
	public static final String[] tokenNames = {
		"<INVALID>", "'requestN'", "'channel'", "'subscribe'", "'request'", "'fire'", 
		"'namespace'", "'message'", "MESSAGE_TYPE", "'service'", "'returns'", 
		"';'", "'{'", "'}'", "'('", "')'", "IDENTIFIER", "QUALIFIED_IDENTIFIER", 
		"WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_laser_raptor = 0, RULE_namespace = 1, RULE_message = 2, RULE_message_name = 3, 
		RULE_message_field = 4, RULE_service = 5, RULE_service_name = 6, RULE_service_definition = 7, 
		RULE_service_func_returns = 8, RULE_service_func_void = 9;
	public static final String[] ruleNames = {
		"laser_raptor", "namespace", "message", "message_name", "message_field", 
		"service", "service_name", "service_definition", "service_func_returns", 
		"service_func_void"
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
	public static class Laser_raptorContext extends ParserRuleContext {
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public List<MessageContext> message() {
			return getRuleContexts(MessageContext.class);
		}
		public MessageContext message(int i) {
			return getRuleContext(MessageContext.class,i);
		}
		public ServiceContext service() {
			return getRuleContext(ServiceContext.class,0);
		}
		public Laser_raptorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_laser_raptor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterLaser_raptor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitLaser_raptor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitLaser_raptor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Laser_raptorContext laser_raptor() throws RecognitionException {
		Laser_raptorContext _localctx = new Laser_raptorContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_laser_raptor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20); namespace();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MESSAGE) {
				{
				{
				setState(21); message();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27); service();
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

	public static class NamespaceContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON() { return getToken(LaserRaptorParser.SEMI_COLON, 0); }
		public TerminalNode QUALIFIED_IDENTIFIER() { return getToken(LaserRaptorParser.QUALIFIED_IDENTIFIER, 0); }
		public TerminalNode NAMESPACE() { return getToken(LaserRaptorParser.NAMESPACE, 0); }
		public NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitNamespace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitNamespace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceContext namespace() throws RecognitionException {
		NamespaceContext _localctx = new NamespaceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); match(NAMESPACE);
			setState(30); match(QUALIFIED_IDENTIFIER);
			setState(31); match(SEMI_COLON);
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

	public static class MessageContext extends ParserRuleContext {
		public TerminalNode L_CURLY() { return getToken(LaserRaptorParser.L_CURLY, 0); }
		public Message_fieldContext message_field(int i) {
			return getRuleContext(Message_fieldContext.class,i);
		}
		public TerminalNode MESSAGE() { return getToken(LaserRaptorParser.MESSAGE, 0); }
		public List<MessageContext> message() {
			return getRuleContexts(MessageContext.class);
		}
		public MessageContext message(int i) {
			return getRuleContext(MessageContext.class,i);
		}
		public List<Message_fieldContext> message_field() {
			return getRuleContexts(Message_fieldContext.class);
		}
		public Message_nameContext message_name() {
			return getRuleContext(Message_nameContext.class,0);
		}
		public TerminalNode R_CURLY() { return getToken(LaserRaptorParser.R_CURLY, 0); }
		public MessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageContext message() throws RecognitionException {
		MessageContext _localctx = new MessageContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_message);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); match(MESSAGE);
			setState(34); message_name();
			setState(35); match(L_CURLY);
			setState(36); message_field();
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MESSAGE || _la==MESSAGE_TYPE) {
				{
				setState(39);
				switch (_input.LA(1)) {
				case MESSAGE_TYPE:
					{
					setState(37); message_field();
					}
					break;
				case MESSAGE:
					{
					setState(38); message();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44); match(R_CURLY);
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

	public static class Message_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(LaserRaptorParser.IDENTIFIER, 0); }
		public Message_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterMessage_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitMessage_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitMessage_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Message_nameContext message_name() throws RecognitionException {
		Message_nameContext _localctx = new Message_nameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_message_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); match(IDENTIFIER);
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

	public static class Message_fieldContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON() { return getToken(LaserRaptorParser.SEMI_COLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LaserRaptorParser.IDENTIFIER, 0); }
		public TerminalNode MESSAGE_TYPE() { return getToken(LaserRaptorParser.MESSAGE_TYPE, 0); }
		public Message_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterMessage_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitMessage_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitMessage_field(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Message_fieldContext message_field() throws RecognitionException {
		Message_fieldContext _localctx = new Message_fieldContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_message_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(MESSAGE_TYPE);
			setState(49); match(IDENTIFIER);
			setState(50); match(SEMI_COLON);
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

	public static class ServiceContext extends ParserRuleContext {
		public Service_nameContext service_name() {
			return getRuleContext(Service_nameContext.class,0);
		}
		public TerminalNode L_CURLY() { return getToken(LaserRaptorParser.L_CURLY, 0); }
		public Service_definitionContext service_definition(int i) {
			return getRuleContext(Service_definitionContext.class,i);
		}
		public List<Service_definitionContext> service_definition() {
			return getRuleContexts(Service_definitionContext.class);
		}
		public TerminalNode SERVICE() { return getToken(LaserRaptorParser.SERVICE, 0); }
		public TerminalNode R_CURLY() { return getToken(LaserRaptorParser.R_CURLY, 0); }
		public ServiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_service; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterService(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitService(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitService(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceContext service() throws RecognitionException {
		ServiceContext _localctx = new ServiceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_service);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); match(SERVICE);
			setState(53); service_name();
			setState(54); match(L_CURLY);
			setState(55); service_definition();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << 3) | (1L << 4) | (1L << 5))) != 0)) {
				{
				{
				setState(56); service_definition();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62); match(R_CURLY);
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

	public static class Service_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(LaserRaptorParser.IDENTIFIER, 0); }
		public Service_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_service_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterService_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitService_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitService_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Service_nameContext service_name() throws RecognitionException {
		Service_nameContext _localctx = new Service_nameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_service_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(IDENTIFIER);
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

	public static class Service_definitionContext extends ParserRuleContext {
		public Service_func_returnsContext service_func_returns() {
			return getRuleContext(Service_func_returnsContext.class,0);
		}
		public Service_func_voidContext service_func_void() {
			return getRuleContext(Service_func_voidContext.class,0);
		}
		public Service_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_service_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterService_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitService_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitService_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Service_definitionContext service_definition() throws RecognitionException {
		Service_definitionContext _localctx = new Service_definitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_service_definition);
		try {
			setState(68);
			switch (_input.LA(1)) {
			case 1:
			case 2:
			case 3:
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(66); service_func_returns();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(67); service_func_void();
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

	public static class Service_func_returnsContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON() { return getToken(LaserRaptorParser.SEMI_COLON, 0); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(LaserRaptorParser.IDENTIFIER, i);
		}
		public TerminalNode RETURNS() { return getToken(LaserRaptorParser.RETURNS, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(LaserRaptorParser.IDENTIFIER); }
		public Service_func_returnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_service_func_returns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterService_func_returns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitService_func_returns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitService_func_returns(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Service_func_returnsContext service_func_returns() throws RecognitionException {
		Service_func_returnsContext _localctx = new Service_func_returnsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_service_func_returns);
		try {
			setState(110);
			switch (_input.LA(1)) {
			case 4:
				enterOuterAlt(_localctx, 1);
				{
				setState(70); match(4);
				setState(71); match(IDENTIFIER);
				setState(72); match(L_PAREN);
				setState(73); match(IDENTIFIER);
				setState(74); match(R_PAREN);
				setState(75); match(RETURNS);
				setState(76); match(L_PAREN);
				setState(77); match(IDENTIFIER);
				setState(78); match(R_PAREN);
				setState(79); match(SEMI_COLON);
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 2);
				{
				setState(80); match(1);
				setState(81); match(IDENTIFIER);
				setState(82); match(L_PAREN);
				setState(83); match(IDENTIFIER);
				setState(84); match(R_PAREN);
				setState(85); match(RETURNS);
				setState(86); match(L_PAREN);
				setState(87); match(IDENTIFIER);
				setState(88); match(R_PAREN);
				setState(89); match(SEMI_COLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90); match(3);
				setState(91); match(IDENTIFIER);
				setState(92); match(L_PAREN);
				setState(93); match(IDENTIFIER);
				setState(94); match(R_PAREN);
				setState(95); match(RETURNS);
				setState(96); match(L_PAREN);
				setState(97); match(IDENTIFIER);
				setState(98); match(R_PAREN);
				setState(99); match(SEMI_COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 4);
				{
				setState(100); match(2);
				setState(101); match(IDENTIFIER);
				setState(102); match(L_PAREN);
				setState(103); match(IDENTIFIER);
				setState(104); match(R_PAREN);
				setState(105); match(RETURNS);
				setState(106); match(L_PAREN);
				setState(107); match(IDENTIFIER);
				setState(108); match(R_PAREN);
				setState(109); match(SEMI_COLON);
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

	public static class Service_func_voidContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON() { return getToken(LaserRaptorParser.SEMI_COLON, 0); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(LaserRaptorParser.IDENTIFIER, i);
		}
		public TerminalNode RETURNS() { return getToken(LaserRaptorParser.RETURNS, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(LaserRaptorParser.IDENTIFIER); }
		public Service_func_voidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_service_func_void; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).enterService_func_void(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LaserRaptorListener ) ((LaserRaptorListener)listener).exitService_func_void(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LaserRaptorVisitor ) return ((LaserRaptorVisitor<? extends T>)visitor).visitService_func_void(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Service_func_voidContext service_func_void() throws RecognitionException {
		Service_func_voidContext _localctx = new Service_func_voidContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_service_func_void);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(5);
			setState(113); match(IDENTIFIER);
			setState(114); match(L_PAREN);
			setState(115); match(IDENTIFIER);
			setState(116); match(R_PAREN);
			setState(117); match(RETURNS);
			setState(118); match(L_PAREN);
			setState(119); match(IDENTIFIER);
			setState(120); match(R_PAREN);
			setState(121); match(SEMI_COLON);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26~\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\7\7<\n\7\f\7\16\7?\13\7\3\7\3\7\3\b\3\b\3\t\3\t\5\t"+
		"G\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nq\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2{\2\26\3\2"+
		"\2\2\4\37\3\2\2\2\6#\3\2\2\2\b\60\3\2\2\2\n\62\3\2\2\2\f\66\3\2\2\2\16"+
		"B\3\2\2\2\20F\3\2\2\2\22p\3\2\2\2\24r\3\2\2\2\26\32\5\4\3\2\27\31\5\6"+
		"\4\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\35\3\2"+
		"\2\2\34\32\3\2\2\2\35\36\5\f\7\2\36\3\3\2\2\2\37 \7\b\2\2 !\7\23\2\2!"+
		"\"\7\r\2\2\"\5\3\2\2\2#$\7\t\2\2$%\5\b\5\2%&\7\16\2\2&+\5\n\6\2\'*\5\n"+
		"\6\2(*\5\6\4\2)\'\3\2\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3"+
		"\2\2\2-+\3\2\2\2./\7\17\2\2/\7\3\2\2\2\60\61\7\22\2\2\61\t\3\2\2\2\62"+
		"\63\7\n\2\2\63\64\7\22\2\2\64\65\7\r\2\2\65\13\3\2\2\2\66\67\7\13\2\2"+
		"\678\5\16\b\289\7\16\2\29=\5\20\t\2:<\5\20\t\2;:\3\2\2\2<?\3\2\2\2=;\3"+
		"\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\17\2\2A\r\3\2\2\2BC\7\22\2\2"+
		"C\17\3\2\2\2DG\5\22\n\2EG\5\24\13\2FD\3\2\2\2FE\3\2\2\2G\21\3\2\2\2HI"+
		"\7\6\2\2IJ\7\22\2\2JK\7\20\2\2KL\7\22\2\2LM\7\21\2\2MN\7\f\2\2NO\7\20"+
		"\2\2OP\7\22\2\2PQ\7\21\2\2Qq\7\r\2\2RS\7\3\2\2ST\7\22\2\2TU\7\20\2\2U"+
		"V\7\22\2\2VW\7\21\2\2WX\7\f\2\2XY\7\20\2\2YZ\7\22\2\2Z[\7\21\2\2[q\7\r"+
		"\2\2\\]\7\5\2\2]^\7\22\2\2^_\7\20\2\2_`\7\22\2\2`a\7\21\2\2ab\7\f\2\2"+
		"bc\7\20\2\2cd\7\22\2\2de\7\21\2\2eq\7\r\2\2fg\7\4\2\2gh\7\22\2\2hi\7\20"+
		"\2\2ij\7\22\2\2jk\7\21\2\2kl\7\f\2\2lm\7\20\2\2mn\7\22\2\2no\7\21\2\2"+
		"oq\7\r\2\2pH\3\2\2\2pR\3\2\2\2p\\\3\2\2\2pf\3\2\2\2q\23\3\2\2\2rs\7\7"+
		"\2\2st\7\22\2\2tu\7\20\2\2uv\7\22\2\2vw\7\21\2\2wx\7\f\2\2xy\7\20\2\2"+
		"yz\7\22\2\2z{\7\21\2\2{|\7\r\2\2|\25\3\2\2\2\b\32)+=Fp";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}