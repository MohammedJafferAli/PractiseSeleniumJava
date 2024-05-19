import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElementByCssSelector {

    public static void main(String[] args) {

        //Setup browser before the actual code
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        //Error message will display after few seconds , so Selenium codes should wait to see the element - called synchronization.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Get to the page / application under test
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //Login with invalid creds
        WebElement inpUsername = driver.findElement(By.id("inputUsername"));
        WebElement inpPassword = driver.findElement(By.name("inputPassword"));
        WebElement btnLogin = driver.findElement(By.className("submit"));
        inpUsername.sendKeys("Jaffer");
        inpPassword.sendKeys("IncorrectPassword");
        btnLogin.click();

        //Validate the inline error message
        String loginErrMessage = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(loginErrMessage);


        //Ensure closing the driver once the purpose is fulfilled.
        driver.close();

    }
}
