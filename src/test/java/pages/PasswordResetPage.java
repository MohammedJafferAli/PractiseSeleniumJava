package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordResetPage extends BasePage {
    
    private static final By FORGOT_PASSWORD_LINK = By.linkText("Forgot your password?");
    private static final By NAME_INPUT = By.xpath("//input[@placeholder='Name']");
    private static final By EMAIL_INPUT = By.xpath("//input[@type='text'][2]");
    private static final By PHONE_INPUT = By.xpath("//form//input[3]");
    private static final By RESET_BUTTON = By.cssSelector(".reset-pwd-btn");
    private static final By SUCCESS_MESSAGE = By.cssSelector("form p");
    private static final By ERROR_MESSAGE = By.cssSelector("p.error");
    
    public PasswordResetPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void clickForgotPassword() {
        click(FORGOT_PASSWORD_LINK);
    }
    
    public void enterName(String name) {
        sendKeys(NAME_INPUT, name);
    }
    
    public void enterEmail(String email) {
        sendKeys(EMAIL_INPUT, email);
    }
    
    public void enterPhone(String phone) {
        sendKeys(PHONE_INPUT, phone);
    }
    
    public void clickReset() {
        click(RESET_BUTTON);
    }
    
    public String getSuccessMessage() {
        return getText(SUCCESS_MESSAGE);
    }
    
    public String getErrorMessage() {
        return getText(ERROR_MESSAGE);
    }
}
