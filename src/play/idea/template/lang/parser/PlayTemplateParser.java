package play.idea.template.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import play.idea.template.lang.lexer.PlayTemplateTokenTypes;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */
public class PlayTemplateParser implements PsiParser {

    @NotNull
    public ASTNode parse(IElementType root, PsiBuilder builder) {
        builder.setDebugMode(true);
        final PsiBuilder.Marker rootMarker = builder.mark();
        while (!builder.eof()) {
            parse(builder);
        }
        rootMarker.done(root);
        return builder.getTreeBuilt();
    }

// @{Clients.showAccounts(client.id)}
// @@{Clients.index()}
// %{ groovy code }%
// ${ groovy expression }
// &{'clientName', client.name}
// #{tag param1:value, param2:value/}


    private void parse(PsiBuilder builder) {
        IElementType t = builder.getTokenType();
        if (t == PlayTemplateElementTypes.ACTION_LINK) {
            PsiBuilder.Marker m = builder.mark();
            parseActionLink(builder);
            parseExpressionEnd(builder);
            m.done(PlayTemplateElementTypes.ACTION_LINK);

        } else if (t == PlayTemplateTokenTypes.HASH) {

        } else if (t == PlayTemplateTokenTypes.AMP) {

        } else {
            builder.advanceLexer();
            builder.error("Unrecognized Play expression");
        }
    }

    private void parseExpressionEnd(PsiBuilder builder) {
        if(builder.getTokenType() != PlayTemplateTokenTypes.RBRACE) {
            builder.advanceLexer();
            builder.error("Expecting }");
        } else {
            builder.advanceLexer();
        }
    }

    private void parseActionLink(PsiBuilder builder) {
        builder.advanceLexer();
        PsiBuilder.Marker controllerClass = builder.mark();
        PsiBuilder.Marker action = null;
        while(!(builder.eof() || builder.getTokenType() == PlayTemplateTokenTypes.LPAREN)) {
            if(builder.getTokenType() != PlayTemplateTokenTypes.IDENTIFIER && builder.getTokenType() != PlayTemplateTokenTypes.DOT) {
                builder.advanceLexer();
                builder.error("Controller class or action expected");
                break;
            }
            if(builder.getTokenType() == PlayTemplateTokenTypes.DOT && builder.lookAhead(2) == PlayTemplateTokenTypes.LPAREN) {
                controllerClass.done(PlayTemplateElementTypes.CONTROLLER_CLASS);
                builder.advanceLexer();
                action = builder.mark();
            }
            builder.advanceLexer();
        }
        action.done(PlayTemplateElementTypes.ACTION_NAME);
        builder.advanceLexer();
        if(builder.getTokenType() != PlayTemplateTokenTypes.RPAREN) {
            builder.advanceLexer();
            builder.error("Action parameters not implemented yet");
        } else {
            builder.advanceLexer();
        }

    }
}
