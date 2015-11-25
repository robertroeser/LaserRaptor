// Generated from /Users/rroeser/projects/LaserRaptor/src/main/antlr4/LaserRaptor.g4 by ANTLR 4.2.2

package laser.raptor.antlr;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LaserRaptorParser}.
 */
public interface LaserRaptorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#service_func_void}.
	 * @param ctx the parse tree
	 */
	void enterService_func_void(@NotNull LaserRaptorParser.Service_func_voidContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#service_func_void}.
	 * @param ctx the parse tree
	 */
	void exitService_func_void(@NotNull LaserRaptorParser.Service_func_voidContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#message_field}.
	 * @param ctx the parse tree
	 */
	void enterMessage_field(@NotNull LaserRaptorParser.Message_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#message_field}.
	 * @param ctx the parse tree
	 */
	void exitMessage_field(@NotNull LaserRaptorParser.Message_fieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#message_name}.
	 * @param ctx the parse tree
	 */
	void enterMessage_name(@NotNull LaserRaptorParser.Message_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#message_name}.
	 * @param ctx the parse tree
	 */
	void exitMessage_name(@NotNull LaserRaptorParser.Message_nameContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#service}.
	 * @param ctx the parse tree
	 */
	void enterService(@NotNull LaserRaptorParser.ServiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#service}.
	 * @param ctx the parse tree
	 */
	void exitService(@NotNull LaserRaptorParser.ServiceContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#service_name}.
	 * @param ctx the parse tree
	 */
	void enterService_name(@NotNull LaserRaptorParser.Service_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#service_name}.
	 * @param ctx the parse tree
	 */
	void exitService_name(@NotNull LaserRaptorParser.Service_nameContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#namespace}.
	 * @param ctx the parse tree
	 */
	void enterNamespace(@NotNull LaserRaptorParser.NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#namespace}.
	 * @param ctx the parse tree
	 */
	void exitNamespace(@NotNull LaserRaptorParser.NamespaceContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#service_definition}.
	 * @param ctx the parse tree
	 */
	void enterService_definition(@NotNull LaserRaptorParser.Service_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#service_definition}.
	 * @param ctx the parse tree
	 */
	void exitService_definition(@NotNull LaserRaptorParser.Service_definitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#laser_raptor}.
	 * @param ctx the parse tree
	 */
	void enterLaser_raptor(@NotNull LaserRaptorParser.Laser_raptorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#laser_raptor}.
	 * @param ctx the parse tree
	 */
	void exitLaser_raptor(@NotNull LaserRaptorParser.Laser_raptorContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#service_func_returns}.
	 * @param ctx the parse tree
	 */
	void enterService_func_returns(@NotNull LaserRaptorParser.Service_func_returnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#service_func_returns}.
	 * @param ctx the parse tree
	 */
	void exitService_func_returns(@NotNull LaserRaptorParser.Service_func_returnsContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#message}.
	 * @param ctx the parse tree
	 */
	void enterMessage(@NotNull LaserRaptorParser.MessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#message}.
	 * @param ctx the parse tree
	 */
	void exitMessage(@NotNull LaserRaptorParser.MessageContext ctx);
}