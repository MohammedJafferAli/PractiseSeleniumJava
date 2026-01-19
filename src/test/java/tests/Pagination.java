package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.PaginationPage;

public class Pagination extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
    
    @Test(priority = 1)
    public void testGetUnitPriceOfVeggie() {
        PaginationPage paginationPage = new PaginationPage(getDriver());
        paginationPage.navigateTo(TEST_URL);
        String price = paginationPage.findVeggiePrice("Carrot");
        System.out.println("Carrot price: " + price);
    }
    
    @Test(priority = 2)
    public void testGetDiscountPriceOfVeggie() {
        PaginationPage paginationPage = new PaginationPage(getDriver());
        paginationPage.navigateTo(TEST_URL);
        String price = paginationPage.findVeggieDiscountPrice("Mango");
        System.out.println("Mango discount price: " + price);
    }
}
