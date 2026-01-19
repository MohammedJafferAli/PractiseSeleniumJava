package interviewAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class LinksOnAPage {

    public static void main(String[] args) {
        //Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1. Find the total no of links present on the page - hint all links in an DOM must be <a> tag
        System.out.println("Links present on the page " + driver.findElements(By.tagName("a")).size());

        //2. Find the total no of links on in the footer section - create a minidriver using main driver
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println("Links present in the footer section: " + footerDriver.findElements(By.tagName("a")).size());

        //3. Create mini driver and find links in a particular category and ensure the links are not broken
        WebElement columnDriver = footerDriver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul"));
        List<WebElement> courses = columnDriver.findElements(By.tagName("a"));
        System.out.println("Links present in the discount coupon section: " + courses.size());

        //4. Click on each link & open in a new tab
        for (int i = 1; i < courses.size(); i++) {
            String openInNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER); //use COMMAND for MAC
            //String openInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER); for windows
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(openInNewTab);
        }

        //5. Get the title of each page to verify the links are opened
        Set<String> handles = driver.getWindowHandles();
        for(String handle:handles)
        {
            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());
        }

        driver.quit();


    }

}
