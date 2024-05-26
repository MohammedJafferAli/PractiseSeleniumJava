import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDownSelectCity {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

       WebElement inpFieldFromCity =  driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
       inpFieldFromCity.click();

       // Source box has the same list of cities in the destination list, so here the parent xpath is either source or destination and find the city inside the respective box

       driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[contains(text(),' Coimbatore')]")).click();
       Thread.sleep(1000);

       driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[contains(text(),' Pune')]")).click();

       driver.quit();
    }
}
