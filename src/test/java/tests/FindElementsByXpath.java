package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.PasswordResetPage;

public class FindElementsByXpath extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/locatorspractice/";
    
    @Test
    public void testPasswordReset() {
        PasswordResetPage resetPage = new PasswordResetPage(getDriver());
        resetPage.navigateTo(TEST_URL);
        resetPage.clickForgotPassword();
        resetPage.enterName("Mohammed");
        resetPage.enterEmail("TestMail_bf1@yopmail.com");
        resetPage.enterPhone("9xxxx33779");
        resetPage.clickReset();
        System.out.println(resetPage.getSuccessMessage());
    }
}
