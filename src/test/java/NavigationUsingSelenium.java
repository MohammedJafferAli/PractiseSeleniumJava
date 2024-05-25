import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationUsingSelenium {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        //Navigate is a class used in selenium to control the browser navigation.
        //Adding wait to see the changes
        Thread.sleep(500);
        driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
        // Back method to navigate previous page and forward method next page

        driver.navigate().back();
        Thread.sleep(500);
        driver.navigate().forward();

        driver.quit();
    }
}
