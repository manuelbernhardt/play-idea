package play.idea.template.lang.lexer;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import play.idea.template.PlayTemplateFileType;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */
public class PlayElementType extends IElementType {
    public PlayElementType(@NotNull String debugName) {
        super(debugName, PlayTemplateFileType.PLAY_LANGUAGE);
    }

    @NotNull
    @Override
    public Language getLanguage() {
        return PlayTemplateFileType.PLAY_LANGUAGE;
    }


}
