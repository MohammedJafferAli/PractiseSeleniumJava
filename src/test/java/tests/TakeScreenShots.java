package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.ScreenshotHelper;

import java.io.IOException;

public class TakeScreenShots extends BaseTest {
    
    private static final String TEST_URL = "https://www.javatpoint.com/";
    private static final String SCREENSHOT_DIR = "/Users/mohammedjafferali/Documents/PractiseSeleniumJava/PractiseSeleniumJava/Screenshots";
    
    @Test
    public void testTakeScreenshot() throws IOException {
        getDriver().get(TEST_URL);
        String titleOfThePage = getDriver().getTitle();
        ScreenshotHelper.takeScreenshot(getDriver(), titleOfThePage, SCREENSHOT_DIR);
    }
}
