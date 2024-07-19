package Assignments;

/*
Goals
1.Check the first  Checkbox and verify if it is successfully checked
and Uncheck it again to verify if it is successfully Unchecked
2. Get the Count of number of check boxes present in the page
*
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static java.lang.Boolean.*;

public class Assignment1 {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        String expectedAlertMessage = "Option2";
        //Setup driver
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Goal 1
        WebElement option1 = driver.findElement(By.id("checkBoxOption1"));
        option1.click();
        Thread.sleep(500); // Adding wait to see the changes visibly
        if (option1.isSelected()) {
            option1.click();
        } else System.out.println(option1.getText() + " is not selected");
        Thread.sleep(500);

        //Goal 2
        System.out.println(driver.findElements(By.xpath("//*[@type='checkbox']")).size());
        driver.quit();
    }
}
