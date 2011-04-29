package play.idea.template.lang.lexer;

import java.io.Reader;

import com.intellij.lexer.FlexAdapter;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */
public class PlayTemplateLexer extends FlexAdapter {

    public PlayTemplateLexer() {
        super(new _PlayTemplateExpressionLexer((Reader) null));
    }
}
