//Add implicit wait globally

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitTest {
    public static void main(String[] args) {
        //Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        //Implicit wait - Global - to each and every step
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String expectedLoginMessage = "You logged into a secure area!";

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String actualLoginMessage = driver.findElement(By.id("flash")).getText().trim();
        System.out.println(actualLoginMessage);

        //Teardown
        Assert.assertEquals(actualLoginMessage, expectedLoginMessage);
        driver.quit();

    }
}
