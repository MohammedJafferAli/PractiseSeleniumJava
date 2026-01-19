package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {
    
    private static final By NAME_INPUT = By.cssSelector("input#name");
    private static final By CONFIRM_BUTTON = By.cssSelector("input#confirmbtn");
    
    public AlertPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void enterName(String name) {
        sendKeys(NAME_INPUT, name);
    }
    
    public void clickConfirmButton() {
        click(CONFIRM_BUTTON);
    }
    
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
}
