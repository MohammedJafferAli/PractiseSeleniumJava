package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PasswordResetPage;

public class FindElementByCssSelector extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/locatorspractice/";
    
    @Test
    public void testLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        PasswordResetPage resetPage = new PasswordResetPage(getDriver());
        
        loginPage.navigateTo(TEST_URL);
        loginPage.login("Jaffer", "IncorrectPassword");
        
        String errorMessage = resetPage.getErrorMessage();
        System.out.println(errorMessage);
    }
}
