package Assignments;

/*
Goals
1. Login into the application
2. Add all products to the cart on shop page
3. Get the count of the product from checkout button
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment3 {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //Setup driver
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       //Capture the elements
        WebElement userName = driver.findElement(By.id("username"));
        WebElement pswd = driver.findElement(By.id("password"));
        WebElement rdbuser = driver.findElement(By.cssSelector("input[value=user]"));
        WebElement chkBoxTerms = driver.findElement(By.cssSelector("#terms"));
        WebElement alertAccept = driver.findElement(By.id("okayBtn"));

        //Goal 1 Enter the details on the login page
        userName.sendKeys("rahulshettyacademy");
        pswd.sendKeys("learning");
        rdbuser.click();

        //Apply explicit wait concept and wait until the alert appears
        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));

        alertAccept.click();
        chkBoxTerms.click();
        driver.findElement(By.id("signInBtn")).click();

        //Goal 2
        List<WebElement> produts = driver.findElements(By.cssSelector("div.card-footer button"));
        for(WebElement product:produts)
        {
            product.click();
        }
        //Goal 3
        String txtCheckout = driver.findElement(By.xpath("//div[@id='navbarResponsive']/ul/li/a")).getText().trim();
        System.out.println(txtCheckout);

        driver.quit();

    }
}
