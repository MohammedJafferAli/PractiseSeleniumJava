//https://rahulshettyacademy.com/seleniumPractise/#/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;


public class ExplicitWaitTest {

    public static void main(String[] args) throws InterruptedException {

        //Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        //Add item and navigate to cart
        driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]")).click();
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        Thread.sleep(500);
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();

       /* WebDriverWait wait = new WebDriverWait(driver, 10); -> In internet you will see this statement but here 10 is an integer
        but we have to use Duration class to give the time here*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Wait for the promocode to apply
        WebElement promoApplied = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));

        if (promoApplied.isDisplayed())
        {
            System.out.println(promoApplied.getText());
        }
        else
        {
            System.out.println("Exception in applying promo");
        }
        driver.quit();
    }
}
