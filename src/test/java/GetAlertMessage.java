import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAlertMessage {

    public static void main(String[] args) {
        //Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Test to get the alert message
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input#name")).sendKeys("Jaffer"); // Enter your name
        driver.findElement(By.cssSelector("input#alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);

        //Tear down
        driver.switchTo().alert().dismiss();
        driver.quit();

    }
}
