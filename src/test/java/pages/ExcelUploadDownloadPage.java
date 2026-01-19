package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExcelUploadDownloadPage extends BasePage {
    
    private static final By DOWNLOAD_BUTTON = By.id("downloadButton");
    private static final By FILE_INPUT = By.id("fileinput");
    private static final By TABLE_ROWS = By.xpath("//div[@role='row' and @id]");
    private static final By TABLE_HEADERS = By.xpath("//div[@role='columnheader']//div[contains(@class, 'sc-eTNRI')]");
    
    public ExcelUploadDownloadPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void clickDownload() {
        click(DOWNLOAD_BUTTON);
    }
    
    public void uploadFile(String filePath) {
        findElement(FILE_INPUT).sendKeys(filePath);
    }
    
    public List<WebElement> getTableRows() {
        return driver.findElements(TABLE_ROWS);
    }
    
    public List<WebElement> getTableHeaders() {
        return driver.findElements(TABLE_HEADERS);
    }
    
    public String getCellValue(WebElement row, int cellIndex) {
        List<WebElement> cells = row.findElements(By.xpath(".//div[@role='cell']"));
        return cells.size() > cellIndex ? cells.get(cellIndex).getText() : "";
    }
    
    public WebElement findFruitInTable(String fruitName) {
        return waitHelper.waitForVisibilityOfElement(
            By.xpath("//div[@role='cell']//div[text()='" + fruitName + "']")
        );
    }
}
