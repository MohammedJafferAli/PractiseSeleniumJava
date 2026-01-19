package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarPage extends BasePage {
    
    private static final By CALENDAR_BUTTON = By.id("ddayno");
    private static final By ACTIVE_DATE = By.cssSelector("li.active-date");
    
    public CalendarPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void openCalendar() {
        click(CALENDAR_BUTTON);
    }
    
    public void selectTodayDate() {
        click(ACTIVE_DATE);
    }
}
