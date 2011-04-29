package play.idea.template.lang.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */
public class PlayTemplatePSIElement extends ASTWrapperPsiElement {

    public PlayTemplatePSIElement(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String toString() {
        return getNode().getElementType().toString();
    }


}
