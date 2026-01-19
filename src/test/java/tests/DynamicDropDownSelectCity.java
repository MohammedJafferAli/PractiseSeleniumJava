package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DynamicDropDownSelectCity extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/dropdownsPractise/";
    
    @Test
    public void testDynamicDropdown() throws InterruptedException {
        DropdownPage dropdownPage = new DropdownPage(getDriver());
        dropdownPage.navigateTo(TEST_URL);
        dropdownPage.selectFromCity(" Coimbatore");
        Thread.sleep(1000);
        dropdownPage.selectToCity(" Pune");
    }
}
