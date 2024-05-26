import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestDropDownCountry {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        // Arab - Partial text
        //United Arab Emirates - Country Name

        selectCountryUsingAutoSuggest(driver,"Arab","United Arab Emirates" );

        driver.quit();


    }

    public static void selectCountryUsingAutoSuggest(WebDriver driver, String partialCountryName, String CountryName) throws InterruptedException {

        WebElement autoSuggestCountry = driver.findElement(By.id("autosuggest"));
        autoSuggestCountry.clear();
        autoSuggestCountry.sendKeys(partialCountryName);
        Thread.sleep(500);

        List<WebElement> suggestedCountries = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

        for (WebElement country : suggestedCountries) {

            ;
            if (country.getText().equalsIgnoreCase(CountryName)) {
                country.click();
            }
        }
        Thread.sleep(500);
        System.out.println(autoSuggestCountry.getText());

    }

}
