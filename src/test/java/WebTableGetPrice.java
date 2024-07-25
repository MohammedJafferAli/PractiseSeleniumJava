import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import java.util.List;
import java.util.stream.Collectors;

/*
 * Goals
 * Get the price of specific veggie
 * */

public class WebTableGetPrice {

    private static WebDriver driver;

    //Goal 2
    @Test(enabled = true)
    public void getOneVeggiePrice() {

        List<WebElement> elementList = driver.findElements(By.xpath("//tbody/tr/td[1]")); //returns only webelement
        List<String> veggiePrice = elementList.stream().filter(s->s.getText().contains("Rice")).map(WebTableGetPrice::getVeggiePrice).collect(Collectors.toList());
        veggiePrice.forEach(System.out::println);

    }

    private static String getVeggiePrice(WebElement s) {
        String price =  s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;
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
