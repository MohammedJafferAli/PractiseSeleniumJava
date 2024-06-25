import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

    public static void main(String[] args) throws InterruptedException {
        //Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://jqueryui.com/droppable/");

        //Test to find frames in the default DOM
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        //To switch into the frames need any one of these 3 - frame id, name or element
        WebElement dropiframe = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(dropiframe);//step 15 tells how many frames available since only 1 is available array index starts from 0
        // - this is not recommended when the frames are in rapidly changing apps

        //Drag the draggable element into droppable element and verify the message
        Actions action = new Actions(driver);
        WebElement sourceLocation = driver.findElement(By.id("draggable"));
        WebElement targetLocation = driver.findElement(By.id("droppable"));
        Thread.sleep(500);
        action.dragAndDrop(sourceLocation,targetLocation).build().perform();

        System.out.println(targetLocation.getText());
        Thread.sleep(500);

        driver.quit();

    }
}
