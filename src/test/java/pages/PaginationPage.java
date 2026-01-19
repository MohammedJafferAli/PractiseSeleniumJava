package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class PaginationPage extends BasePage {
    
    private static final By VEGGIE_CELLS = By.xpath("//tbody/tr/td[1]");
    private static final By NEXT_BUTTON = By.cssSelector("[aria-label='Next']");
    
    public PaginationPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public String findVeggiePrice(String veggieName) {
        List<String> prices;
        do {
            prices = getVeggiePrices(veggieName);
            if (prices.isEmpty()) {
                clickNext();
            }
        } while (prices.isEmpty());
        return prices.isEmpty() ? "" : prices.get(0);
    }
    
    public String findVeggieDiscountPrice(String veggieName) {
        List<String> prices;
        do {
            prices = getVeggieDiscountPrices(veggieName);
            if (prices.isEmpty()) {
                clickNext();
            }
        } while (prices.isEmpty());
        return prices.isEmpty() ? "" : prices.get(0);
    }
    
    private List<String> getVeggiePrices(String veggieName) {
        return driver.findElements(VEGGIE_CELLS).stream()
                     .filter(e -> e.getText().contains(veggieName))
                     .map(e -> e.findElement(By.xpath("following-sibling::td[1]")).getText())
                     .collect(Collectors.toList());
    }
    
    private List<String> getVeggieDiscountPrices(String veggieName) {
        return driver.findElements(VEGGIE_CELLS).stream()
                     .filter(e -> e.getText().contains(veggieName))
                     .map(e -> e.findElement(By.xpath("following-sibling::td[2]")).getText())
                     .collect(Collectors.toList());
    }
    
    private void clickNext() {
        click(NEXT_BUTTON);
    }
}
