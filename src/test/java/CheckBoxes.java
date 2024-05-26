import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        WebElement seniorCitizenDiscount = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
        // Printing on the console without using assertion
        System.out.println(seniorCitizenDiscount.isSelected());
        Thread.sleep(500);
        seniorCitizenDiscount.click();
        Thread.sleep(500);
        System.out.println(seniorCitizenDiscount.isSelected());

        //using assertion to test
        Assert.assertTrue(seniorCitizenDiscount.isSelected());
        seniorCitizenDiscount.click();
        Thread.sleep(500);
        Assert.assertFalse(seniorCitizenDiscount.isSelected());

        driver.quit();


        //selectEligibleDiscountOption(driver," Senior Citizen");
    }

   /* public static void selectEligibleDiscountOption(WebDriver driver, String eligibleDiscount) throws InterruptedException {
        List<WebElement> discountTypes = driver.findElements(By.cssSelector("label[for*='ctl00_mainContent_chk']"));
        System.out.println("No of Discount options available  " + (discountTypes.size()-1));
        Thread.sleep(500);

        for (WebElement discountType : discountTypes) {
            if (discountType.getText().equalsIgnoreCase(eligibleDiscount)) {
            discountType.click();
            }
        }

    }*/
}
