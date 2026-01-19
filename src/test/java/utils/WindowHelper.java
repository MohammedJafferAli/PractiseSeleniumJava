package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHelper {
    
    public static void switchToChildWindow(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        iterator.next(); // Skip parent window
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
    }
    
    public static void switchToParentWindow(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        String parentWindow = windowHandles.iterator().next();
        driver.switchTo().window(parentWindow);
    }
}
