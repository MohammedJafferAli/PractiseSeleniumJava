package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class PraciseDDPassangerList extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/dropdownsPractise/";
    
    @Test
    public void testPassengerSelection() throws InterruptedException {
        DropdownPage dropdownPage = new DropdownPage(getDriver());
        dropdownPage.navigateTo(TEST_URL);
        
        dropdownPage.openPassengerDropdown();
        Thread.sleep(500);
        
        System.out.println("Before: " + dropdownPage.getPassengerCount());
        
        dropdownPage.addPassengers("Adult", 3);
        dropdownPage.addPassengers("Child", 3);
        dropdownPage.addPassengers("Infant", 3);
        Thread.sleep(500);
        
        dropdownPage.removePassengers("Adult", 1);
        dropdownPage.removePassengers("Child", 1);
        dropdownPage.removePassengers("Infant", 1);
        Thread.sleep(500);
        
        dropdownPage.closePassengerDropdown();
        Thread.sleep(1000);
        
        System.out.println("After: " + dropdownPage.getPassengerCount());
    }
}
