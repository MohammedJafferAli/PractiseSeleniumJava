package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.WebTablePage;

public class WebTableGetPrice extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
    private static final String VEGGIE_NAME = "Rice";
    
    @Test
    public void testGetVeggiePrice() {
        WebTablePage webTablePage = new WebTablePage(getDriver());
        
        webTablePage.navigateTo(TEST_URL);
        
        String price = webTablePage.getVeggiePrice(VEGGIE_NAME);
        System.out.println(VEGGIE_NAME + " price: " + price);
    }
}
