import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {
//Setup driver
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();

        //Forgot password
        WebElement lnkForgotPassword = driver.findElement(By.cssSelector(".forgot-pwd-container a"));
        lnkForgotPassword.click();
        Thread.sleep(500);

        //Reset password
        driver.findElement(By.xpath("//*[@class='reset-pwd-btn']")).click();
        WebElement infoMessageWithTempPassword = driver.findElement(By.cssSelector("p.infoMsg"));
        String tempPassword = infoMessageWithTempPassword.getText().split("'")[1].split("'")[0];
        System.out.println(tempPassword);

        //Login with temp password
        driver.findElement(By.className("go-to-login-btn")).click();
        Thread.sleep(500);

//Find username field and enter your name
        WebElement inpUsername = driver.findElement(By.id("inputUsername"));
        inpUsername.sendKeys("Jaffer");

        //Find username field and enter your name
        WebElement inpPassword = driver.findElement(By.name("inputPassword"));
        inpPassword.sendKeys(tempPassword);

        //Login
        WebElement btnLogin = driver.findElement(By.className("submit"));
        btnLogin.click();

        driver.quit();
    }
}
