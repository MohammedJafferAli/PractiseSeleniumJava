package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends BasePage {
    
    private static final By AUTO_SUGGEST_INPUT = By.id("autosuggest");
    private static final By AUTO_SUGGEST_OPTIONS = By.xpath("//li[@class='ui-menu-item']");
    private static final By FROM_CITY_INPUT = By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
    private static final By TO_CITY_INPUT = By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']");
    private static final By CURRENCY_DROPDOWN = By.id("ctl00_mainContent_DropDownListCurrency");
    private static final By PASSENGER_DROPDOWN = By.id("divpaxinfo");
    private static final By ADULT_INCREMENT = By.id("hrefIncAdt");
    private static final By CHILD_INCREMENT = By.id("hrefIncChd");
    private static final By INFANT_INCREMENT = By.id("hrefIncInf");
    private static final By ADULT_DECREMENT = By.id("hrefDecAdt");
    private static final By CHILD_DECREMENT = By.id("hrefDecChd");
    private static final By INFANT_DECREMENT = By.id("hrefDecInf");
    private static final By PASSENGER_DONE = By.id("btnclosepaxoption");
    
    public DropdownPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void selectCountryFromAutoSuggest(String partialText, String fullCountryName) {
        sendKeys(AUTO_SUGGEST_INPUT, partialText);
        List<WebElement> options = driver.findElements(AUTO_SUGGEST_OPTIONS);
        options.stream()
               .filter(option -> option.getText().equalsIgnoreCase(fullCountryName))
               .findFirst()
               .ifPresent(WebElement::click);
    }
    
    public void selectFromCity(String city) {
        click(FROM_CITY_INPUT);
        By cityLocator = By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[contains(text(),'" + city + "')]");
        click(cityLocator);
    }
    
    public void selectToCity(String city) {
        By cityLocator = By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[contains(text(),'" + city + "')]");
        click(cityLocator);
    }
    
    public void selectCurrency(String currency) {
        Select select = new Select(findElement(CURRENCY_DROPDOWN));
        select.selectByVisibleText(currency);
    }
    
    public void selectCurrencyByIndex(int index) {
        Select select = new Select(findElement(CURRENCY_DROPDOWN));
        select.selectByIndex(index);
    }
    
    public void selectCurrencyByValue(String value) {
        Select select = new Select(findElement(CURRENCY_DROPDOWN));
        select.selectByValue(value);
    }
    
    public void openPassengerDropdown() {
        click(PASSENGER_DROPDOWN);
    }
    
    public void addPassengers(String type, int count) {
        By locator = getPassengerLocator(type, true);
        for (int i = 1; i < count; i++) {
            click(locator);
        }
    }
    
    public void removePassengers(String type, int count) {
        By locator = getPassengerLocator(type, false);
        for (int i = 0; i < count; i++) {
            click(locator);
        }
    }
    
    public void closePassengerDropdown() {
        click(PASSENGER_DONE);
    }
    
    public String getPassengerCount() {
        return getText(PASSENGER_DROPDOWN);
    }
    
    private By getPassengerLocator(String type, boolean increment) {
        switch (type) {
            case "Adult": return increment ? ADULT_INCREMENT : ADULT_DECREMENT;
            case "Child": return increment ? CHILD_INCREMENT : CHILD_DECREMENT;
            case "Infant": return increment ? INFANT_INCREMENT : INFANT_DECREMENT;
            default: throw new IllegalArgumentException("Invalid passenger type: " + type);
        }
    }
}
