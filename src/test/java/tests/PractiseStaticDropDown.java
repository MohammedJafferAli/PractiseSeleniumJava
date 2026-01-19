package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class PractiseStaticDropDown extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/dropdownsPractise/";
    
    @Test
    public void testStaticDropdown() throws InterruptedException {
        DropdownPage dropdownPage = new DropdownPage(getDriver());
        dropdownPage.navigateTo(TEST_URL);
        
        dropdownPage.selectCurrency("USD");
        Thread.sleep(500);
        dropdownPage.selectCurrencyByIndex(2);
        Thread.sleep(500);
        dropdownPage.selectCurrencyByValue("AED");
    }
}
