package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/locatorspractice/";
    private static final String USERNAME = "Jaffer";
    
    @Test
    public void testLoginWithTemporaryPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        
        loginPage.navigateTo(TEST_URL);
        loginPage.clickForgotPassword();
        loginPage.clickResetPassword();
        
        String tempPassword = loginPage.extractTemporaryPassword();
        
        loginPage.clickGoToLogin();
        loginPage.login(USERNAME, tempPassword);
    }
}
