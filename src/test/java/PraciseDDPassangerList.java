import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PraciseDDPassangerList {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        WebElement passengers = driver.findElement(By.id("divpaxinfo"));
        passengers.click();
        Thread.sleep(500);
        //Before adding passangers
        System.out.println(getPassangerCount(driver));
        addPassngers(driver, "Adult", 3);
        addPassngers(driver, "Child", 3);
        addPassngers(driver, "Infant", 3);
        Thread.sleep(500);
        removePassngers(driver, "Adult", 1);
        removePassngers(driver, "Child", 1);
        removePassngers(driver, "Infant", 1);
        Thread.sleep(500);
        WebElement btncomplete = driver.findElement(By.id("btnclosepaxoption"));
        btncomplete.click();
        Thread.sleep(1000);

        //After adding passangers
        System.out.println(getPassangerCount(driver));

        driver.quit();

    }

    public static String getPassangerCount(WebDriver driver) {
        return driver.findElement(By.id("divpaxinfo")).getText();
    }

    public static void addPassngers(WebDriver driver, String typeOfPassanger, int noOfPassangers) {
        WebElement eleAdult = driver.findElement(By.id("hrefIncAdt"));
        WebElement eleChild = driver.findElement(By.id("hrefIncChd"));
        WebElement eleInfant = driver.findElement(By.id("hrefIncInf"));


        WebElement passanger = null;
        if (typeOfPassanger.equals("Adult")) {
            passanger = eleAdult;
        } else if (typeOfPassanger.equals("Child")) {
            passanger = eleChild;
        } else if (typeOfPassanger.equals("Infant")) {
            passanger = eleInfant;
        }
        for (int count = 1; count < noOfPassangers; count++) {
            passanger.click();
        }

    }

    public static void removePassngers(WebDriver driver, String typeOfPassanger, int noOfPassangers) {
        WebElement eleAdult = driver.findElement(By.id("hrefDecAdt"));
        WebElement eleChild = driver.findElement(By.id("hrefDecChd"));
        WebElement eleInfant = driver.findElement(By.id("hrefDecInf"));


        WebElement passanger = null;
        switch (typeOfPassanger) {
            case "Adult":
                passanger = eleAdult;
                break;
            case "Child":
                passanger = eleChild;
                break;
            case "Infant":
                passanger = eleInfant;
                break;

        }
        for (int count = 0; count < noOfPassangers; count++) {
            passanger.click();
        }

    }


}
