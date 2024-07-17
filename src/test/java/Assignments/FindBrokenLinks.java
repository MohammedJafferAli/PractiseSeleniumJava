package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FindBrokenLinks {
    private static WebDriver driver;

    public static void main(String[] args) throws IOException {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        //Find a single link is broken or not
        WebElement link1 = driver.findElement(By.xpath("//a[text()='REST API']"));
        // li[class=gf-li] a - all links in the given page
        URL url1 = new URL(link1.getAttribute("href")); // Handle the URLs

        //Use java HttpURLConnect Class to create an object send the request and verify the response code
        HttpURLConnection connection1 = (HttpURLConnection) url1.openConnection();

        connection1.setRequestMethod("HEAD");
        connection1.connect();

        int respCode = connection1.getResponseCode();
        System.out.println(respCode);
        System.out.println("End of single link validation");

        /* ############################################################################ */
        //Verify all the links in the footer section are broken or not
        // Introducing soft assertion to verify the result and continue to next iteration

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> links = driver.findElements(By.cssSelector("li[class=gf-li] a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

            connection.setRequestMethod("HEAD");
            connection.getResponseCode();
            int responseCode = connection.getResponseCode();
            System.out.println(link.getText() + " - " + responseCode);
            softAssert.assertTrue(responseCode < 400, "The Link " + link.getText() + " is broken with the status code " + responseCode);

        }
        softAssert.assertAll();
        driver.close();
    }

}
