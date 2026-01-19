package tests;

package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FramesPage;

public class FramesTest extends BaseTest {
    
    private static final String TEST_URL = "https://jqueryui.com/droppable/";
    
    @Test
    public void testDragAndDropInFrame() throws InterruptedException {
        FramesPage framesPage = new FramesPage(getDriver());
        
        framesPage.navigateTo(TEST_URL);
        
        int frameCount = framesPage.getFrameCount();
        System.out.println("Frame count: " + frameCount);
        
        framesPage.switchToFrame();
        
        Thread.sleep(500);
        framesPage.dragAndDrop();
        
        String droppableText = framesPage.getDroppableText();
        System.out.println("Droppable text: " + droppableText);
        
        Thread.sleep(500);
    }
}
