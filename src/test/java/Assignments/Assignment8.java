package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment8 {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        selectTheCountry("uni", "United Kingdom (UK)");


        driver.close();

    }

    public static void selectTheCountry( String partialName, String countryName) throws InterruptedException {
        WebElement inpCountry = driver.findElement(By.cssSelector("input#autocomplete"));
        inpCountry.sendKeys(partialName);
        Thread.sleep(500);

        //li.ui-menu-item - auto suggestion dropdown

        List<WebElement> suggestedCountries = driver.findElements(By.cssSelector("li.ui-menu-item"));
        for (int country = 0; country < suggestedCountries.size(); country++) {
            String actualCountryName = suggestedCountries.get(country).getText();

            //System.out.println(actualCountryName);

            if (actualCountryName.equals(countryName)) {
                suggestedCountries.get(country).click();
                Thread.sleep(500);
            }
        }

        System.out.println(inpCountry.getAttribute("value"));
    }
}
