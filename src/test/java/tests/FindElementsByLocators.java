package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class FindElementsByLocators extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/locatorspractice/";
    
    @Test
    public void testFindElements() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateTo(TEST_URL);
        loginPage.enterUsername("Jaffer");
        loginPage.enterPassword("rahulshetyacademy");
        loginPage.clickLogin();
        Thread.sleep(500);
    }
}
