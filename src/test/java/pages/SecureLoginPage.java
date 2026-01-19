package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureLoginPage extends BasePage {
    
    private static final By USERNAME_INPUT = By.id("username");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By SUBMIT_BUTTON = By.cssSelector("button[type='submit']");
    private static final By FLASH_MESSAGE = By.id("flash");
    
    public SecureLoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void enterUsername(String username) {
        sendKeys(USERNAME_INPUT, username);
    }
    
    public void enterPassword(String password) {
        sendKeys(PASSWORD_INPUT, password);
    }
    
    public void clickSubmit() {
        click(SUBMIT_BUTTON);
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmit();
    }
    
    public String getFlashMessage() {
        return getText(FLASH_MESSAGE).trim();
    }
}
