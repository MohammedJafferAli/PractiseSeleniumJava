package Assignments;

/*
Goals
1. Launch the application and select Multiple window hyperlink
2. Open a New window and get child window text
3. Switch back to parent window and get the text
*
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assignment4 {

    private static WebDriver driver;

    public static void main(String[] args) {
        //Setup driver
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Goal 1
        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();


        Set<String> windowsHandles = driver.getWindowHandles(); //[parentID, childID]
        Iterator<String> iterator = windowsHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        //Goal 2
        driver.switchTo().window(childWindow);
        String childWindowText = driver.findElement(By.tagName("h3")).getText();
        System.out.println(childWindowText);

        //Goal 3
        driver.switchTo().window(parentWindow);
        String parentWindowText = driver.findElement(By.tagName("h3")).getText();
        System.out.println(parentWindowText);

        driver.quit();

    }
}
