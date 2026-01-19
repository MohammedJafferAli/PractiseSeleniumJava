package tests;

package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.JavaScriptHelper;

public class PageScrollingUsingJSExecutor extends BaseTest {
    
    private static final String TEST_URL = "https://www.javatpoint.com/";
    
    @Test
    public void testPageScrolling() throws InterruptedException {
        getDriver().get(TEST_URL);
        JavaScriptHelper jsHelper = new JavaScriptHelper(getDriver());
        
        jsHelper.scrollToBottom();
        Thread.sleep(500);
        
        jsHelper.scrollToTop();
        
        jsHelper.scrollVertically(500);
        Thread.sleep(500);
        
        jsHelper.scrollHorizontally(500);
        Thread.sleep(500);
        
        WebElement graphQl = getDriver().findElement(By.xpath("//p[contains(text(),'GraphQL')]"));
        jsHelper.scrollToElement(graphQl);
    }
}

