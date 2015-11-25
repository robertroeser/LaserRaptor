// Generated from /Users/rroeser/projects/LaserRaptor/src/main/antlr4/LaserRaptor.g4 by ANTLR 4.2.2

package laser.raptor.antlr;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LaserRaptorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LaserRaptorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#service_func_void}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService_func_void(@NotNull LaserRaptorParser.Service_func_voidContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#message_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage_field(@NotNull LaserRaptorParser.Message_fieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#message_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage_name(@NotNull LaserRaptorParser.Message_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService(@NotNull LaserRaptorParser.ServiceContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#service_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService_name(@NotNull LaserRaptorParser.Service_nameContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#namespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespace(@NotNull LaserRaptorParser.NamespaceContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#service_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService_definition(@NotNull LaserRaptorParser.Service_definitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#laser_raptor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLaser_raptor(@NotNull LaserRaptorParser.Laser_raptorContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#service_func_returns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService_func_returns(@NotNull LaserRaptorParser.Service_func_returnsContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage(@NotNull LaserRaptorParser.MessageContext ctx);
}