package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class AutoSuggestDropDownCountry extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/dropdownsPractise/";
    
    @Test
    public void testAutoSuggestCountry() {
        DropdownPage dropdownPage = new DropdownPage(getDriver());
        dropdownPage.navigateTo(TEST_URL);
        dropdownPage.selectCountryFromAutoSuggest("Arab", "United Arab Emirates");
    }
}
