package play.idea.template;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */
public class PlayTemplateFile extends PsiFileBase implements PsiFile {

    public PlayTemplateFile(FileViewProvider fileViewProvider, @NotNull Language language) {
        super(fileViewProvider, language);
    }

    @NotNull
    public FileType getFileType() {
        return PlayTemplateFileType.PLAY_TEMPLATE_FILE_TYPE;
    }

    @Override
    public String toString() {
        return "Play Template Expression";
    }
}
