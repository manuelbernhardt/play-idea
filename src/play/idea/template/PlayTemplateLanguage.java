package play.idea.template;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */
public class PlayTemplateLanguage extends Language {

    public PlayTemplateLanguage() {
        super("Play", "text/play");
    }

    @Override
    public LanguageFileType getAssociatedFileType() {
        return PlayTemplateFileType.PLAY_TEMPLATE_FILE_TYPE;
    }

    @Override
    public boolean isCaseSensitive() {
        return true;
    }
}
