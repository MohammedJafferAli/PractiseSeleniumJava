package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CalendarPage;

public class HandleCalenderToday extends BaseTest {
    
    private static final String TEST_URL = "https://www.easemytrip.com/flights.html";
    
    @Test
    public void testSelectTodayDate() throws InterruptedException {
        CalendarPage calendarPage = new CalendarPage(getDriver());
        calendarPage.navigateTo(TEST_URL);
        
        Thread.sleep(500);
        calendarPage.openCalendar();
        Thread.sleep(500);
        calendarPage.selectTodayDate();
        Thread.sleep(500);
    }
}
