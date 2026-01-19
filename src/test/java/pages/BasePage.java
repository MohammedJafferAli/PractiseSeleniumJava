package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelper;

public abstract class BasePage {
    
    protected WebDriver driver;
    protected WaitHelper waitHelper;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }
    
    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    
    protected void click(By locator) {
        waitHelper.waitForElementToBeClickable(locator).click();
    }
    
    protected void sendKeys(By locator, String text) {
        WebElement element = waitHelper.waitForVisibilityOfElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    protected String getText(By locator) {
        return waitHelper.waitForVisibilityOfElement(locator).getText();
    }
}
