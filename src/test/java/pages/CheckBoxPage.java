package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends BasePage {
    
    private static final By SENIOR_CITIZEN_CHECKBOX = By.cssSelector("input[id*='SeniorCitizenDiscount']");
    
    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void clickSeniorCitizenCheckbox() {
        click(SENIOR_CITIZEN_CHECKBOX);
    }
    
    public boolean isSeniorCitizenCheckboxSelected() {
        return findElement(SENIOR_CITIZEN_CHECKBOX).isSelected();
    }
}
