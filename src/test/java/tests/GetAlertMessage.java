package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AlertPage;

public class GetAlertMessage extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/AutomationPractice/";
    
    @Test
    public void testGetAlertText() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.navigateTo(TEST_URL);
        
        getDriver().findElement(org.openqa.selenium.By.cssSelector("input#name")).sendKeys("Jaffer");
        getDriver().findElement(org.openqa.selenium.By.cssSelector("input#alertbtn")).click();
        
        String alertText = getDriver().switchTo().alert().getText();
        System.out.println(alertText);
        
        getDriver().switchTo().alert().dismiss();
    }
}
