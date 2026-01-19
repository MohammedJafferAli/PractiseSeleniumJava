package tests;

package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class ExplicitWaitTest extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/seleniumPractise/";
    private static final String PROMO_CODE = "rahulshettyacademy";
    
    @Test
    public void testPromoCodeApplication() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        
        checkoutPage.navigateTo(TEST_URL);
        checkoutPage.addItemToCart();
        checkoutPage.openCart();
        checkoutPage.proceedToCheckout();
        
        Thread.sleep(500);
        checkoutPage.enterPromoCode(PROMO_CODE);
        checkoutPage.applyPromoCode();
        
        Assert.assertTrue(checkoutPage.isPromoInfoDisplayed());
        System.out.println(checkoutPage.getPromoInfoText());
    }
}
