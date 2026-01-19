package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FramesPage extends BasePage {
    
    private static final By IFRAME = By.cssSelector(".demo-frame");
    private static final By DRAGGABLE = By.id("draggable");
    private static final By DROPPABLE = By.id("droppable");
    
    private final Actions actions;
    
    public FramesPage(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public int getFrameCount() {
        return driver.findElements(By.tagName("iframe")).size();
    }
    
    public void switchToFrame() {
        WebElement iframe = findElement(IFRAME);
        driver.switchTo().frame(iframe);
    }
    
    public void dragAndDrop() {
        WebElement source = findElement(DRAGGABLE);
        WebElement target = findElement(DROPPABLE);
        actions.dragAndDrop(source, target).build().perform();
    }
    
    public String getDroppableText() {
        return getText(DROPPABLE);
    }
}
