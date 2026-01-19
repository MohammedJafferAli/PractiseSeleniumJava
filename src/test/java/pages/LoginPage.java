package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    
    private static final By FORGOT_PASSWORD_LINK = By.cssSelector(".forgot-pwd-container a");
    private static final By RESET_PASSWORD_BUTTON = By.xpath("//*[@class='reset-pwd-btn']");
    private static final By INFO_MESSAGE = By.cssSelector("p.infoMsg");
    private static final By GO_TO_LOGIN_BUTTON = By.className("go-to-login-btn");
    private static final By USERNAME_INPUT = By.id("inputUsername");
    private static final By PASSWORD_INPUT = By.name("inputPassword");
    private static final By LOGIN_BUTTON = By.className("submit");
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void clickForgotPassword() {
        click(FORGOT_PASSWORD_LINK);
    }
    
    public void clickResetPassword() {
        click(RESET_PASSWORD_BUTTON);
    }
    
    public String extractTemporaryPassword() {
        String message = getText(INFO_MESSAGE);
        return message.split("'")[1];
    }
    
    public void clickGoToLogin() {
        click(GO_TO_LOGIN_BUTTON);
    }
    
    public void enterUsername(String username) {
        sendKeys(USERNAME_INPUT, username);
    }
    
    public void enterPassword(String password) {
        sendKeys(PASSWORD_INPUT, password);
    }
    
    public void clickLogin() {
        click(LOGIN_BUTTON);
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
