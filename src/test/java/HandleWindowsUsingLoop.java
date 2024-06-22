import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandleWindowsUsingLoop {
    public static void main(String[] args) {

        //Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demoqa.com/browser-windows");

        WebElement btnNewWindow = driver.findElement(By.id("windowButton"));
        btnNewWindow.click();

        Set<String> windowHandles = driver.getWindowHandles();
        //1st window will always be parent window
        String parentWindow = driver.getWindowHandle();
        //Find all the child windows

        for(String handle:windowHandles)
        {
            if(!(handle.equals(parentWindow)))
            {
                driver.switchTo().window(handle);
            }

        }
        WebElement newWindowMessage = driver.findElement(By.id("sampleHeading"));
        System.out.println("Text on the new window "+ newWindowMessage);

        //switch to parent window
        String switchedParentWindowTitle = driver.switchTo().window(parentWindow).getTitle();
        System.out.println(switchedParentWindowTitle);

        driver.close();//to check only parent window is closed
    }

}
