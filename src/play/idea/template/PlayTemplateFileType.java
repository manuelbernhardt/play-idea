package play.idea.template;

import javax.swing.*;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */
public class PlayTemplateFileType extends LanguageFileType {

    public static final PlayTemplateFileType PLAY_TEMPLATE_FILE_TYPE = new PlayTemplateFileType();
    public static final Language PLAY_LANGUAGE = PLAY_TEMPLATE_FILE_TYPE.getLanguage();
    public static final String DEFAULT_EXTENSION = "play";

    private PlayTemplateFileType() {
        super(new PlayTemplateLanguage());
    }

    @NotNull
    public String getName() {
        return "Play";
    }

    @NotNull
    public String getDescription() {
        return null;
    }

    @NotNull
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    public Icon getIcon() {
        return null;
    }

    public String getCharset(@NotNull VirtualFile virtualFile, byte[] bytes) {
        return null;
    }
}
