import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleWindowsUsingIterator {
    public static void main(String[] args) {

        //Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demoqa.com/browser-windows");

        WebElement openNewTab = driver.findElement(By.id("tabButton"));
        openNewTab.click();

        //Get all the open windows
       Set<String> windowsHandles = driver.getWindowHandles(); //[parentID, childID]
        Iterator<String> iterator = windowsHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        //Switch to child tab
        driver.switchTo().window(childWindow);
        String captureInfo = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(captureInfo);

        //switch back to parent tab
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());

    }
}
