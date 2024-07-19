package Assignments;

/*
Goals
1. Switch between the frames and get the text
*
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Assignment5 {
    private static WebDriver driver;

    public static void main(String[] args) {
        //Setup driver
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Goal 1
        driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();

        //Logic is there are 2 major frames in the DOM - top & Bottom.
        // In order to get the "LEFT" , "MIDDLE", "RIGHT" switch to top then to each frames

        List<WebElement> allFrames = driver.findElements(By.tagName("frame"));

        for (WebElement frame : allFrames) {
            driver.switchTo().frame(frame);//top bottom
            List<WebElement> childFrames = driver.findElements(By.tagName("frame"));

            if (childFrames.size() > 1) {
                for (WebElement child : childFrames) // top - LEFT , MIDDLE , RIGHT
                {
                    driver.switchTo().frame(child);
                    System.out.println(driver.findElement(By.tagName("body")).getText());
                    driver.switchTo().parentFrame();//Everytime we need to go back to the parent frame to move the next child frame
                }
            } else {

                System.out.println(driver.findElement(By.tagName("body")).getText());
            }
            driver.switchTo().parentFrame();// Move from top to parent then to bottom
        }
        driver.quit();

    }
}
