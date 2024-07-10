import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleCalenderToday {
    public static void main(String[] args) throws InterruptedException {

        //Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.easemytrip.com/flights.html");

        //Select the current date from the calender
        Thread.sleep(500);
        WebElement calender = driver.findElement(By.id("ddayno"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(calender)).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("li.active-date")).click();//Identified by the unique class name
        Thread.sleep(500);


    }
}
