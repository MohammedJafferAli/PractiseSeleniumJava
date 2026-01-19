package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class WebTablePage extends BasePage {
    
    private static final By TOP_DEALS_LINK = By.xpath("//a[contains(text(),'Top Deals')]");
    private static final By PAGE_SIZE_DROPDOWN = By.cssSelector("#page-menu");
    private static final By VEGGIE_COLUMN_HEADER = By.xpath("//tr/th[1]");
    private static final By VEGGIE_CELLS = By.xpath("//tbody/tr/td[1]");
    
    public WebTablePage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void clickTopDeals() {
        click(TOP_DEALS_LINK);
    }
    
    public void selectPageSize(String size) {
        Select dropdown = new Select(findElement(PAGE_SIZE_DROPDOWN));
        dropdown.selectByVisibleText(size);
    }
    
    public void clickVeggieColumnHeader() {
        click(VEGGIE_COLUMN_HEADER);
    }
    
    public List<String> getVeggieList() {
        return driver.findElements(VEGGIE_CELLS)
                     .stream()
                     .map(WebElement::getText)
                     .collect(Collectors.toList());
    }
    
    public String getVeggiePrice(String veggieName) {
        List<WebElement> veggies = driver.findElements(VEGGIE_CELLS);
        return veggies.stream()
                      .filter(s -> s.getText().contains(veggieName))
                      .map(s -> s.findElement(By.xpath("following-sibling::td[1]")).getText())
                      .findFirst()
                      .orElse("");
    }
}
