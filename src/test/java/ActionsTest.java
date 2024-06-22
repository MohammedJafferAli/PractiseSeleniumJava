import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

    public static void main(String[] args) throws InterruptedException {

        //Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.in/");

        //Create an object for actions class
        Actions action = new Actions(driver);

        //Test to perform different actions on this amazon website
        //Move to element = mouse hover
        WebElement accountsNLinks = driver.findElement(By.cssSelector("a#nav-link-accountList"));
        action.moveToElement(accountsNLinks).build().perform();
        Thread.sleep(500);

        //mimic the mouse action in the search bar
        WebElement inpSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        action.moveToElement(inpSearchBox).click().keyDown(Keys.SHIFT).sendKeys("magazine").build().perform();

        //Double click action
        action.doubleClick().build().perform();

        driver.quit();




    }
}
