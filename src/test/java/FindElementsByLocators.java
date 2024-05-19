/* Task to find the different locators in the given url / page
and interact with them using selenium webdriver using java program*/


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsByLocators {

    public static void main(String[] args) throws InterruptedException {

        //Setup browser before the actual code
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Get to the page / application under test
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //Find username field and enter your name
        WebElement inpUsername = driver.findElement(By.id("inputUsername"));
        inpUsername.sendKeys("Jaffer");

        //Find username field and enter your name
        WebElement inpPassword = driver.findElement(By.name("inputPassword"));
        inpPassword.sendKeys("rahulshetyacademy");

        //Login
        WebElement btnLogin = driver.findElement(By.className("submit"));
        btnLogin.click();


        Thread.sleep(500);
        //Ensure closing the driver once the purpose is fulfilled.
        driver.close();
    }
}
