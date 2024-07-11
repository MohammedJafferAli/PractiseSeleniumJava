import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenShots {

    private static WebDriver driver; //Define driver Object a Class Member
    public static void main(String[] args) throws IOException {
        //Setup driver
        driver = new ChromeDriver();
        driver.get("https://www.javatpoint.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //recommended to create a separate method for reusability
        String titleOfThePage = driver.getTitle();
        TakeScreenShot(titleOfThePage);

        driver.close();

    }

    public static void TakeScreenShot(String FileName) throws IOException {

        // Create File object and save screenshot of current webpage inside it
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Copy screenshot file to a location with some name and extension you want
        FileUtils.copyFile(screenshot, new File( "/Users/mohammedjafferali/Documents/PractiseSeleniumJava/PractiseSeleniumJava/Screenshots", FileName  +".jpg"));

    }
}
