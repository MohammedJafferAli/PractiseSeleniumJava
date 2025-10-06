import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDownloadModifyUploadTest {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private String downloadPath;
    private String testDataFile;
    
    @BeforeClass
    public void setUp() {
        // Setup download directory
        downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
        testDataFile = downloadPath + File.separator + "download.xlsx";
        
        // Setup Chrome options for file download
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
        
        // Initialize WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @Test(priority = 1)
    public void testDownloadExcelFile() {
        // Navigate to the application
        driver.get("https://rahulshettyacademy.com/upload-download-test/");
        
        // Clean up any existing download file
        File existingFile = new File(testDataFile);
        if (existingFile.exists()) {
            existingFile.delete();
        }
        
        // Click download button
        WebElement downloadButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("downloadButton"))
        );
        downloadButton.click();
        
        // Wait for file to be downloaded
        waitForFileDownload(testDataFile, 30);
        
        // Verify file exists
        Assert.assertTrue(new File(testDataFile).exists(), "Excel file was not downloaded");
        System.out.println("✓ Excel file downloaded successfully");
    }
    
    @Test(priority = 2, dependsOnMethods = "testDownloadExcelFile")
    public void testModifyExcelFile() throws IOException {
        FileInputStream fis = new FileInputStream(testDataFile);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;
            
            Cell fruitNameCell = row.getCell(1);
            Cell priceCell = row.getCell(3);
            
            if (fruitNameCell != null && priceCell != null) {
                String fruitName = fruitNameCell.getStringCellValue();
                
                if ("Apple".equals(fruitName)) {
                    priceCell.setCellValue(450);
                    System.out.println("✓ Modified Apple price to 450");
                }
                
                if ("Banana".equals(fruitName)) {
                    priceCell.setCellValue(75);
                    System.out.println("✓ Modified Banana price to 75");
                }
            }
        }
        
        fis.close();
        FileOutputStream fos = new FileOutputStream(testDataFile);
        workbook.write(fos);
        fos.close();
        workbook.close();
        
        System.out.println("✓ Excel file modified successfully");
    }
    
    @Test(priority = 3, dependsOnMethods = "testModifyExcelFile")
    public void testUploadFile() {
        // Upload the downloaded file
        WebElement fileInput = driver.findElement(By.id("fileinput"));
        fileInput.sendKeys(testDataFile);
        
        // Wait for upload to complete
        try {
            Thread.sleep(3000); // Wait for upload processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("✓ Excel file uploaded successfully");
    }
    
    @Test(priority = 4, dependsOnMethods = "testUploadFile")
    public void testVerifyTableData() {
        // Verify the data in the web table
        List<WebElement> tableRows = driver.findElements(By.xpath("//div[@role='row' and @id]"));
        
        boolean appleFound = false;
        boolean bananaFound = false;
        
        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.xpath(".//div[@role='cell']"));
            
            if (cells.size() >= 4) {
                String fruitName = cells.get(1).getText();
                String price = cells.get(3).getText();
                
                if ("Apple".equals(fruitName)) {
                    Assert.assertEquals(price, "450", "Apple price was not updated correctly");
                    appleFound = true;
                    System.out.println("✓ Verified Apple price updated to: " + price);
                }
                
                if ("Banana".equals(fruitName)) {
                    Assert.assertEquals(price, "75", "Banana price was not updated correctly");
                    bananaFound = true;
                    System.out.println("✓ Verified Banana price updated to: " + price);
                }
            }
        }
        
        Assert.assertTrue(appleFound, "Apple not found in table");
        Assert.assertTrue(bananaFound, "Banana not found in table");
        
        System.out.println("✓ Modified data verified successfully in table");
    }
    
    @Test(priority = 5)
    public void testTableDataIntegrity() {
        // Verify all expected fruits are present
        String[] expectedFruits = {"Mango", "Apple", "Papaya", "Banana", "Kivi", "Orange"};
        
        for (String fruit : expectedFruits) {
            WebElement fruitElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@role='cell']//div[text()='" + fruit + "']")
                )
            );
            Assert.assertTrue(fruitElement.isDisplayed(), fruit + " is not displayed in the table");
        }
        
        // Verify table structure
        List<WebElement> headers = driver.findElements(
            By.xpath("//div[@role='columnheader']//div[contains(@class, 'sc-eTNRI')]")
        );
        
        String[] expectedHeaders = {"S No", "Fruit Name", "Color", "Price", "Season"};
        Assert.assertEquals(headers.size(), expectedHeaders.length, "Header count mismatch");
        
        for (int i = 0; i < expectedHeaders.length; i++) {
            Assert.assertEquals(headers.get(i).getText(), expectedHeaders[i], 
                "Header mismatch at position " + i);
        }
        
        System.out.println("✓ Table data integrity verified");
    }
    
    private void waitForFileDownload(String filePath, int timeoutSeconds) {
        File file = new File(filePath);
        int waited = 0;
        
        while (!file.exists() && waited < timeoutSeconds) {
            try {
                Thread.sleep(1000);
                waited++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        if (!file.exists()) {
            throw new RuntimeException("File download timeout after " + timeoutSeconds + " seconds");
        }
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        
        // Clean up downloaded file
        File testFile = new File(testDataFile);
        if (testFile.exists()) {
            testFile.delete();
            System.out.println("✓ Test file cleaned up");
        }
    }
}
