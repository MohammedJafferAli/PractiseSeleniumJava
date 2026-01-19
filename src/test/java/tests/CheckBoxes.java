package tests;

package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

public class CheckBoxes extends BaseTest {
    
    private static final String TEST_URL = "https://rahulshettyacademy.com/dropdownsPractise/";
    
    @Test
    public void testCheckBoxSelection() throws InterruptedException {
        CheckBoxPage checkBoxPage = new CheckBoxPage(getDriver());
        
        checkBoxPage.navigateTo(TEST_URL);
        
        Assert.assertFalse(checkBoxPage.isSeniorCitizenCheckboxSelected());
        
        Thread.sleep(500);
        checkBoxPage.clickSeniorCitizenCheckbox();
        Thread.sleep(500);
        
        Assert.assertTrue(checkBoxPage.isSeniorCitizenCheckboxSelected());
        
        checkBoxPage.clickSeniorCitizenCheckbox();
        Thread.sleep(500);
        
        Assert.assertFalse(checkBoxPage.isSeniorCitizenCheckboxSelected());
    }
}
