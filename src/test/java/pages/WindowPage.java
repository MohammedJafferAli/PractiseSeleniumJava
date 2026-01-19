package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage extends BasePage {
    
    private static final By TAB_BUTTON = By.id("tabButton");
    private static final By WINDOW_BUTTON = By.id("windowButton");
    private static final By SAMPLE_HEADING = By.id("sampleHeading");
    
    public WindowPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void openNewTab() {
        click(TAB_BUTTON);
    }
    
    public void openNewWindow() {
        click(WINDOW_BUTTON);
    }
    
    public String getSampleHeading() {
        return getText(SAMPLE_HEADING);
    }
    
    public String getTitle() {
        return driver.getTitle();
    }
}
