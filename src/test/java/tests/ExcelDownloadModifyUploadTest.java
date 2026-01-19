package tests;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ExcelUploadDownloadPage;
import utils.ExcelHelper;
import utils.FileHelper;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDownloadModifyUploadTest extends BaseTest {
    
    private ExcelUploadDownloadPage page;
    private ExcelHelper excelHelper;
    private String downloadPath;
    private String testDataFile;
    private static final String TEST_URL = "https://rahulshettyacademy.com/upload-download-test/";
    
    @BeforeClass
    public void setUpClass() {
        downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
        testDataFile = downloadPath + File.separator + "download.xlsx";
        excelHelper = new ExcelHelper();
    }
    
    @BeforeMethod
    @Override
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver.set(new org.openqa.selenium.chrome.ChromeDriver(getDownloadChromeOptions()));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        page = new ExcelUploadDownloadPage(getDriver());
    }
    
    @Override
    protected ChromeOptions getChromeOptions() {
        return getDownloadChromeOptions();
    }
    
    private ChromeOptions getDownloadChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-notifications");
        return options;
    }
    
    @Test(priority = 1)
    public void testDownloadExcelFile() {
        page.navigateTo(TEST_URL);
        FileHelper.deleteFile(testDataFile);
        
        page.clickDownload();
        
        Assert.assertTrue(FileHelper.waitForFileDownload(testDataFile, 30), 
            "Excel file was not downloaded");
    }
    
    @Test(priority = 2, dependsOnMethods = "testDownloadExcelFile")
    public void testModifyExcelFile() throws IOException {
        Workbook workbook = excelHelper.loadWorkbook(testDataFile);
        Sheet sheet = workbook.getSheetAt(0);
        
        excelHelper.updateCellValue(sheet, "Apple", 1, 3, 450);
        excelHelper.updateCellValue(sheet, "Banana", 1, 3, 75);
        
        excelHelper.saveWorkbook(workbook, testDataFile);
        workbook.close();
    }
    
    @Test(priority = 3, dependsOnMethods = "testModifyExcelFile")
    public void testUploadFile() throws InterruptedException {
        page.uploadFile(testDataFile);
        Thread.sleep(3000);
    }
    
    @Test(priority = 4, dependsOnMethods = "testUploadFile")
    public void testVerifyTableData() {
        List<WebElement> tableRows = page.getTableRows();
        
        boolean appleFound = false;
        boolean bananaFound = false;
        
        for (WebElement row : tableRows) {
            String fruitName = page.getCellValue(row, 1);
            String price = page.getCellValue(row, 3);
            
            if ("Apple".equals(fruitName)) {
                Assert.assertEquals(price, "450", "Apple price was not updated correctly");
                appleFound = true;
            }
            
            if ("Banana".equals(fruitName)) {
                Assert.assertEquals(price, "75", "Banana price was not updated correctly");
                bananaFound = true;
            }
        }
        
        Assert.assertTrue(appleFound, "Apple not found in table");
        Assert.assertTrue(bananaFound, "Banana not found in table");
    }
    
    @Test(priority = 5)
    public void testTableDataIntegrity() {
        String[] expectedFruits = {"Mango", "Apple", "Papaya", "Banana", "Kivi", "Orange"};
        
        for (String fruit : expectedFruits) {
            WebElement fruitElement = page.findFruitInTable(fruit);
            Assert.assertTrue(fruitElement.isDisplayed(), fruit + " is not displayed in the table");
        }
        
        List<WebElement> headers = page.getTableHeaders();
        String[] expectedHeaders = {"S No", "Fruit Name", "Color", "Price", "Season"};
        Assert.assertEquals(headers.size(), expectedHeaders.length, "Header count mismatch");
        
        for (int i = 0; i < expectedHeaders.length; i++) {
            Assert.assertEquals(headers.get(i).getText(), expectedHeaders[i], 
                "Header mismatch at position " + i);
        }
    }
    
    @AfterClass
    public void tearDownClass() {
        FileHelper.deleteFile(testDataFile);
    }
}
