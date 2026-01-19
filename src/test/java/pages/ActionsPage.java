package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsPage extends BasePage {
    
    private static final By ACCOUNTS_AND_LISTS = By.cssSelector("a#nav-link-accountList");
    private static final By SEARCH_BOX = By.id("twotabsearchtextbox");
    
    private final Actions actions;
    
    public ActionsPage(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void hoverOverAccountsAndLists() {
        actions.moveToElement(findElement(ACCOUNTS_AND_LISTS)).build().perform();
    }
    
    public void searchWithShiftKey(String searchText) {
        actions.moveToElement(findElement(SEARCH_BOX))
               .click()
               .keyDown(Keys.SHIFT)
               .sendKeys(searchText)
               .build()
               .perform();
    }
    
    public void doubleClick() {
        actions.doubleClick().build().perform();
    }
}
