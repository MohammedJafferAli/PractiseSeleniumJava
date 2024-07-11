package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7 {
    /* Find a web table, get the row & column count and print a particular row on the console
    * */

    private static WebDriver driver;
    public static void main(String[] args) {
        //Setup
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        //Scroll to the section
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        WebElement WebTableExample = driver.findElement(By.cssSelector("table[name='courses']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", WebTableExample);

        //Get the details from the tables
        int rowCountInCourseTable = driver.findElements(By.xpath("//table[@name='courses'][1]/tbody/tr")).size();

        int columnCountInCourseTable = driver.findElements(By.xpath("//table[@name='courses'][1]/tbody/tr/th")).size();

        System.out.println("row count " +rowCountInCourseTable);
        System.out.println("row count " +columnCountInCourseTable);

        //Limit the driver object scope to table level
        WebElement table = driver.findElement(By.xpath("//table[@name='courses'][1]/tbody"));
       List<WebElement> courses =  table.findElements(By.xpath("//table[@name='courses'][1]/tbody/tr"));

       //Print a particular course  - hardcoded
        List<WebElement> secondrow =table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
        for(WebElement element : secondrow)
        {
            System.out.println(element.getText());
        }

        printTableValue(5, table);

        driver.close();

    }
    public static void printTableValue(int rowNumber, WebElement table )
    {
        List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(rowNumber).findElements(By.tagName("td"));
        for(WebElement element : secondrow)
        {
            System.out.println(element.getText());
        }

    }
}
