package tests;

package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebTablePage;
import utils.WindowHelper;

import java.util.List;
import java.util.stream.Collectors;

public class WebTables extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/seleniumPractise/#/";
    private static final String PAGE_SIZE = "20";
    
    @Test
    public void testWebTableSorting() {
        WebTablePage webTablePage = new WebTablePage(getDriver());
        
        webTablePage.navigateTo(TEST_URL);
        webTablePage.clickTopDeals();
        
        WindowHelper.switchToChildWindow(getDriver());
        
        webTablePage.selectPageSize(PAGE_SIZE);
        
        List<String> beforeSort = webTablePage.getVeggieList();
        List<String> expectedList = beforeSort.stream().sorted().collect(Collectors.toList());
        
        webTablePage.clickVeggieColumnHeader();
        
        List<String> actualList = webTablePage.getVeggieList();
        
        Assert.assertEquals(actualList, expectedList, "Actual veggie list is not matching with sorted list");
    }
}
