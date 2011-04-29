package play.idea.template.lang.parser;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.IStubFileElementType;
import play.idea.template.PlayTemplateLanguage;
import play.idea.template.lang.lexer.PlayElementType;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */
public interface PlayTemplateElementTypes {
    PlayTemplateLanguage LANG = Language.findInstance(PlayTemplateLanguage.class);
    IFileElementType FILE = new IStubFileElementType(LANG);

    IElementType ACTION_LINK = new PlayElementType("ACTION_LINK");
    IElementType CONTROLLER_CLASS = new PlayElementType("CONTROLLER_CLASS");
    IElementType ACTION_NAME = new PlayElementType("ACTION_NAME");
    IElementType ACTION_PARAMS = new PlayElementType("ACTION_PARAMS");
    IElementType ACTION_PARAM_NAME = new PlayElementType("ACTION_PARAM_NAME");
    IElementType ACTION_PARAM_VALUE = new PlayElementType("ACTION_PARAM_VALUE");
}
