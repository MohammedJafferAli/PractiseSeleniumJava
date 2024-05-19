import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class FindElementsByXpath {

    public static void main(String[] args) {
        //Setup browser before the actual code
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //Error message will display after few seconds , so Selenium codes should wait to see the element - called synchronization.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Get to the page / application under test
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //Handle Link element - Forgot password
        driver.findElement(By.linkText("Forgot your password?")).click();

        //Reset user password
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Mohammed");

        WebElement inpEmail = driver.findElement(By.xpath("//input[@type='text'][2]"));
        inpEmail.clear();
        inpEmail.sendKeys("TestMail_bf1@yopmail.com");
        WebElement inpPhoneNumber = driver.findElement(By.xpath("//form//input[3]"));
        inpPhoneNumber.sendKeys("9xxxx33779");

        WebElement btnResetUser = driver.findElement(By.cssSelector(".reset-pwd-btn"));
        btnResetUser.click();

        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        //Ensure closing the driver once the purpose is fulfilled.
        driver.close();

    }
}
