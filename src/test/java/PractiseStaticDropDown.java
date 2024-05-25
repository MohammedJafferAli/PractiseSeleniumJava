import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PractiseStaticDropDown {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        WebElement ddCurrency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        //To interact with static dropdowns, make sure the web element has "Select tag"
        Select selectCurrency = new Select(ddCurrency);

        selectCurrency.selectByVisibleText("USD");
        Thread.sleep(500);
        selectCurrency.selectByIndex(2);
        Thread.sleep(500);
        selectCurrency.selectByValue("AED");

        driver.quit();


    }
}
