package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.WindowPage;

import java.util.Set;

public class HandleWindowsUsingLoop extends BaseTest {
    
    private static final String TEST_URL = "https://demoqa.com/browser-windows";
    
    @Test
    public void testWindowHandlingWithLoop() {
        WindowPage windowPage = new WindowPage(getDriver());
        windowPage.navigateTo(TEST_URL);
        windowPage.openNewWindow();
        
        Set<String> windowHandles = getDriver().getWindowHandles();
        String parentWindow = getDriver().getWindowHandle();
        
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindow)) {
                getDriver().switchTo().window(handle);
            }
        }
        
        System.out.println("Text on the new window: " + windowPage.getSampleHeading());
        
        String switchedParentWindowTitle = getDriver().switchTo().window(parentWindow).getTitle();
        System.out.println(switchedParentWindowTitle);
    }
}
