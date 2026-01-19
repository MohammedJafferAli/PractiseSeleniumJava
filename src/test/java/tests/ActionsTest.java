package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ActionsPage;

public class ActionsTest extends BaseTest {
    
    private static final String TEST_URL = "https://www.amazon.in/";
    private static final String SEARCH_TEXT = "magazine";
    
    @Test
    public void testActionsOnAmazon() throws InterruptedException {
        ActionsPage actionsPage = new ActionsPage(getDriver());
        
        actionsPage.navigateTo(TEST_URL);
        actionsPage.hoverOverAccountsAndLists();
        Thread.sleep(500);
        
        actionsPage.searchWithShiftKey(SEARCH_TEXT);
        actionsPage.doubleClick();
    }
}
