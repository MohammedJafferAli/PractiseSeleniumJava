package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AlertPage;

public class AcknowledgeAlert extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/AutomationPractice/";
    private static final String NAME = "Jaffer";
    
    @Test
    public void testAcceptAlert() throws InterruptedException {
        AlertPage alertPage = new AlertPage(getDriver());
        
        alertPage.navigateTo(TEST_URL);
        alertPage.enterName(NAME);
        alertPage.clickConfirmButton();
        Thread.sleep(3);
        alertPage.acceptAlert();
    }
    
    @Test
    public void testDismissAlert() throws InterruptedException {
        AlertPage alertPage = new AlertPage(getDriver());
        
        alertPage.navigateTo(TEST_URL);
        alertPage.enterName(NAME);
        alertPage.clickConfirmButton();
        Thread.sleep(3);
        alertPage.dismissAlert();
    }
}
