package Assignments;

/*
Goals:
1. Select any 1 option under checkboxes
2. Grab that text of the checkbox
3. Select the same option from the static dropdown without hardcoding
4. enter the same text in the alert input field and trigger the alert
5. verify the option value present in the alert message
*
* */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class Assignment6 {
    private static WebDriver driver;

    public static void main(String[] args) {

        String expectedAlertMessage = "Option2";
        //Setup driver
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Goal 1
        WebElement option = driver.findElement(By.xpath("//label[@for='benz']/input"));
        option.click();
        //Goal 2
        String myOption = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
        System.out.println(myOption);

        //Goal 3
        WebElement optionsDropDown = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(optionsDropDown);

        select.selectByVisibleText(myOption);

        //Goal 4
        driver.findElement(By.cssSelector("input[name='enter-name']")).sendKeys(myOption);
        driver.findElement(By.id("alertbtn")).click();

        String alertMessage = driver.switchTo().alert().getText();

        String actual = alertMessage.split(",")[0].split(" ")[1];
        Assert.assertEquals(actual, expectedAlertMessage);
        driver.switchTo().alert().accept();

        driver.quit();
    }

}
