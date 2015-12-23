// Generated from /Users/rroeser/projects/LaserRaptor/parser/src/main/antlr4/LaserRaptor.g4 by ANTLR 4.2.2

package laser.raptor.antlr.generated;

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
	 * Visit a parse tree produced by {@link LaserRaptorParser#serviceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceBody(@NotNull LaserRaptorParser.ServiceBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#laserRaptor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLaserRaptor(@NotNull LaserRaptorParser.LaserRaptorContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#messageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageDeclaration(@NotNull LaserRaptorParser.MessageDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#namespaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceDeclaration(@NotNull LaserRaptorParser.NamespaceDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#messageBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageBody(@NotNull LaserRaptorParser.MessageBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#messageType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageType(@NotNull LaserRaptorParser.MessageTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#messageBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageBodyDeclaration(@NotNull LaserRaptorParser.MessageBodyDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(@NotNull LaserRaptorParser.QualifiedNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#serviceBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceBodyDeclaration(@NotNull LaserRaptorParser.ServiceBodyDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(@NotNull LaserRaptorParser.FieldDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#serviceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceDeclaration(@NotNull LaserRaptorParser.ServiceDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link LaserRaptorParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull LaserRaptorParser.TypeContext ctx);
}