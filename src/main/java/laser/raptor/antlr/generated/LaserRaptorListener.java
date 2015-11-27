// Generated from /Users/rroeser/projects/LaserRaptor/src/main/antlr4/LaserRaptor.g4 by ANTLR 4.2.2

package laser.raptor.antlr.generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LaserRaptorParser}.
 */
public interface LaserRaptorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#laserRaptor}.
	 * @param ctx the parse tree
	 */
	void enterLaserRaptor(@NotNull LaserRaptorParser.LaserRaptorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#laserRaptor}.
	 * @param ctx the parse tree
	 */
	void exitLaserRaptor(@NotNull LaserRaptorParser.LaserRaptorContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#messageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMessageDeclaration(@NotNull LaserRaptorParser.MessageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#messageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMessageDeclaration(@NotNull LaserRaptorParser.MessageDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#namespaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceDeclaration(@NotNull LaserRaptorParser.NamespaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#namespaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceDeclaration(@NotNull LaserRaptorParser.NamespaceDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#messageBody}.
	 * @param ctx the parse tree
	 */
	void enterMessageBody(@NotNull LaserRaptorParser.MessageBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#messageBody}.
	 * @param ctx the parse tree
	 */
	void exitMessageBody(@NotNull LaserRaptorParser.MessageBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#messageType}.
	 * @param ctx the parse tree
	 */
	void enterMessageType(@NotNull LaserRaptorParser.MessageTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#messageType}.
	 * @param ctx the parse tree
	 */
	void exitMessageType(@NotNull LaserRaptorParser.MessageTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#messageBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMessageBodyDeclaration(@NotNull LaserRaptorParser.MessageBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#messageBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMessageBodyDeclaration(@NotNull LaserRaptorParser.MessageBodyDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(@NotNull LaserRaptorParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(@NotNull LaserRaptorParser.QualifiedNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(@NotNull LaserRaptorParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(@NotNull LaserRaptorParser.FieldDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link LaserRaptorParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull LaserRaptorParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LaserRaptorParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull LaserRaptorParser.TypeContext ctx);
}