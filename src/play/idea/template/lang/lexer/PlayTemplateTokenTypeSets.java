package play.idea.template.lang.lexer;

import com.intellij.psi.tree.TokenSet;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */
public interface PlayTemplateTokenTypeSets extends PlayTemplateTokenTypes {

    public final TokenSet COMMENTS = TokenSet.create(COMMENT);
    public final TokenSet STRINGS = TokenSet.create(IDENTIFIER);
}
