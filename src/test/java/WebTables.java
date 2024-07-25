import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
* To pass the test - run as it is
* To fail the test - change the value of page size to either 5 or 10
* */

public class WebTables {

    private static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        WebElement topDeals = driver.findElement(By.xpath("//a[contains(text(),'Top Deals')]"));
        topDeals.click(); //Open deals in new window

        Set<String> windowsHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowsHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);

        WebElement pageSize = driver.findElement(By.cssSelector("#page-menu"));
        Select ddPageSize = new Select(pageSize);
        ddPageSize.selectByVisibleText("20");

        //Before sort the veggie get the list
        WebElement colVeg = driver.findElement(By.xpath("//tr/th[1]"));
        List<String> beforeSort = WebTables.getVeggieList();
        List<String> expectedList = beforeSort.stream().sorted().collect(Collectors.toList());

        //Sort by name by click on the column header
        colVeg.click();

        //Get list after sorted
        List<String> actualList = WebTables.getVeggieList();

        Assert.assertEquals(actualList, expectedList,"Actual veggie list is not matching with sorted list");
        driver.quit();
    }

    public static List<String> getVeggieList() {
        List<WebElement> veggieList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        return veggieList.stream().map(WebElement::getText).collect(Collectors.toList());

        //veggieList.stream().map(s -> s.getText()).forEach(System.out::println);//Just print it on console

    }
}
