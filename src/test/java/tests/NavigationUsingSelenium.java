package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class NavigationUsingSelenium extends BaseTest {
    
    @Test
    public void testBrowserNavigation() throws InterruptedException {
        getDriver().get("https://www.google.com/");
        Thread.sleep(500);
        
        getDriver().navigate().to("https://rahulshettyacademy.com/locatorspractice/");
        
        getDriver().navigate().back();
        Thread.sleep(500);
        
        getDriver().navigate().forward();
    }
}
