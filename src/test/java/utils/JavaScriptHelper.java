package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
    
    private final JavascriptExecutor jsExecutor;
    
    public JavaScriptHelper(WebDriver driver) {
        this.jsExecutor = (JavascriptExecutor) driver;
    }
    
    public void scrollToBottom() {
        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    public void scrollToTop() {
        jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight,0)");
    }
    
    public void scrollVertically(int pixels) {
        jsExecutor.executeScript("window.scrollBy(0," + pixels + ")");
    }
    
    public void scrollHorizontally(int pixels) {
        jsExecutor.executeScript("window.scrollBy(" + pixels + ",0)");
    }
    
    public void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
