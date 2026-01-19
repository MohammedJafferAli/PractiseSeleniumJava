package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.WindowPage;
import utils.WindowHelper;

public class HandleWindowsUsingIterator extends BaseTest {
    
    private static final String TEST_URL = "https://demoqa.com/browser-windows";
    
    @Test
    public void testWindowHandling() {
        WindowPage windowPage = new WindowPage(getDriver());
        windowPage.navigateTo(TEST_URL);
        windowPage.openNewTab();
        
        WindowHelper.switchToChildWindow(getDriver());
        String captureInfo = windowPage.getSampleHeading();
        System.out.println(captureInfo);
        
        WindowHelper.switchToParentWindow(getDriver());
        System.out.println(windowPage.getTitle());
    }
}
