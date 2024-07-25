import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Pagination {
    private static WebDriver driver;
   private static List<String> veggiePrice;

    @Test(priority = 3, enabled = false)
    public void getPriceUsingPagination() {

        do {
            List<WebElement> webElementList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            veggiePrice = webElementList.stream().filter(s -> s.getText().contains("Banana")).map(s -> getVeggiePrice(s)).collect(Collectors.toList());
            veggiePrice.forEach(System.out::println);
            if(veggiePrice.isEmpty())
            {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while (veggiePrice.isEmpty());

    }

    @Test(priority = 1)
    public void getUnitPriceOfVeggie()
    {
        getUnitPrice("Carrot");
    }


    @Test (priority = 2)
    public void getDiscountPriceOfVeggie()
    {
        getDiscountPrice("Mango");

    }


    private static String getVeggiePrice(WebElement s) {
        String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
    }
    private static String getDiscountPrice(WebElement s) {
        String price = s.findElement(By.xpath("following-sibling::td[2]")).getText();
        return price;
    }

    public static void getUnitPrice(String veggie) {

        do {
            List<WebElement> webElementList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            veggiePrice = webElementList.stream().filter(s -> s.getText().contains(veggie)).map(s -> getVeggiePrice(s)).collect(Collectors.toList());
            veggiePrice.forEach(System.out::println);
            if(veggiePrice.isEmpty())
            {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while (veggiePrice.isEmpty());
    }

    public static void getDiscountPrice(String veggie) {

        do {
            List<WebElement> webElementList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            veggiePrice = webElementList.stream().filter(s -> s.getText().contains(veggie)).map(s -> getDiscountPrice(s)).collect(Collectors.toList());
            veggiePrice.forEach(System.out::println);
            if(veggiePrice.isEmpty())
            {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while (veggiePrice.isEmpty());
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
