package tests;

package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SecureLoginPage;

public class ImplicitWaitTest extends BaseTest {
    
    private static final String TEST_URL = "https://the-internet.herokuapp.com/login";
    private static final String USERNAME = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";
    private static final String EXPECTED_MESSAGE = "You logged into a secure area!";
    
    @Test
    public void testLoginWithImplicitWait() {
        SecureLoginPage loginPage = new SecureLoginPage(getDriver());
        
        loginPage.navigateTo(TEST_URL);
        loginPage.login(USERNAME, PASSWORD);
        
        String actualMessage = loginPage.getFlashMessage();
        Assert.assertEquals(actualMessage, EXPECTED_MESSAGE);
    }
}
