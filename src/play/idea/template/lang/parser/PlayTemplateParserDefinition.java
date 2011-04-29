package play.idea.template.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.xml.XmlTokenType;
import org.jetbrains.annotations.NotNull;
import play.idea.template.PlayTemplateFile;
import play.idea.template.PlayTemplateFileType;
import play.idea.template.lang.lexer.PlayTemplateLexer;
import play.idea.template.lang.lexer.PlayTemplateTokenTypeSets;
import play.idea.template.lang.psi.PlayTemplatePSIElement;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */
public class PlayTemplateParserDefinition implements ParserDefinition {

    public PlayTemplateParserDefinition() {
    }

    @NotNull
    public Lexer createLexer(Project project) {
        return new PlayTemplateLexer();
    }

    public PsiParser createParser(Project project) {
        return new PlayTemplateParser();
    }

    public IFileElementType getFileNodeType() {
        return PlayTemplateElementTypes.FILE;
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return XmlTokenType.WHITESPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return PlayTemplateTokenTypeSets.COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return PlayTemplateTokenTypeSets.STRINGS;
    }

    @NotNull
    public PsiElement createElement(ASTNode astNode) {
        return new PlayTemplatePSIElement(astNode);
    }

    public PsiFile createFile(FileViewProvider fileViewProvider) {
        return new PlayTemplateFile(fileViewProvider, PlayTemplateFileType.PLAY_LANGUAGE);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
        return SpaceRequirements.MAY;
    }
}
