package play.idea.template.lang.parser;

import com.intellij.testFramework.ParsingTestCase;
import com.intellij.testFramework.PlatformTestCase;

/**
 * @author Manuel Bernhardt <bernhardt.manuel@gmail.com>
 */

public class TemplateExpressionTestCase extends ParsingTestCase {

    public TemplateExpressionTestCase() {
        super("", "play");
        PlatformTestCase.initPlatformLangPrefix();
    }

    @Override
    protected String getTestDataPath() {
        return "test/testData/parsing";
    }

    public void testSimpleActionLink() {
        doTest(true);
    }
    public void testPackageControllerActionLink() {
        doTest(true);
    }

}
