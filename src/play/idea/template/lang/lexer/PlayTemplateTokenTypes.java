package play.idea.template.lang.lexer;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */
public interface PlayTemplateTokenTypes extends TokenType {

    IElementType LPAREN = new PlayElementType("LPAREN");
    IElementType RPAREN = new PlayElementType("RPAREN");
    IElementType LBRACE = new PlayElementType("LBRACE");
    IElementType RBRACE = new PlayElementType("RBRACE");
    IElementType COMMA = new PlayElementType("COMMA");
    IElementType DOT = new PlayElementType("DOT");
    IElementType AT = new PlayElementType("AT");
    IElementType HASH = new PlayElementType("HASH");
    IElementType STAR = new PlayElementType("STAR");
    IElementType AMP = new PlayElementType("AMP");
    IElementType DOLLAR = new PlayElementType("DOLLAR");
    IElementType COMMENT = new PlayElementType("COMMENT");
    IElementType IDENTIFIER = new PlayElementType("IDENTIFIER");
}
