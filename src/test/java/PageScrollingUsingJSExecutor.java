import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PageScrollingUsingJSExecutor {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.javatpoint.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Need to create a javascript executor driver to perform javascript commands by parse the original driver
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Scroll to the bottom of the page
        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        Thread.sleep(500); // To see the changes visually

        //Scroll to the top of the page
        jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight,0)");

        //Scroll vertically to a particular point
        jsExecutor.executeScript("window.scrollBy(0,500)");

        Thread.sleep(500); // To see the changes visually

        //Scroll horizontally to a particular point
        jsExecutor.executeScript("window.scrollBy(500,0)");

        Thread.sleep(500); // To see the changes visually

        //Scroll to the visibility of the element
        WebElement GraphQl = driver.findElement(By.xpath("//p[contains(text(),'GraphQL')]"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", GraphQl);

        //driver.close();
    }


}

