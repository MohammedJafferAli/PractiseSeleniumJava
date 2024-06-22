import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcknowledgeAlert {

    public static void main(String[] args) throws InterruptedException {
        //Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Test to accept the alert
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input#name")).sendKeys("Jaffer"); // Enter your name
        driver.findElement(By.cssSelector("input#confirmbtn")).click();
        Thread.sleep(3);
        driver.switchTo().alert().accept();

        //Test to dismiss the alert
        driver.findElement(By.cssSelector("input#name")).sendKeys("Jaffer"); // Enter your name
        driver.findElement(By.cssSelector("input#confirmbtn")).click();
        Thread.sleep(3);
        driver.switchTo().alert().dismiss();

        //Tear down
        driver.quit();
    }
}
