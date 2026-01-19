package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    
    private static final By ADD_TO_CART_BUTTON = By.xpath("//button[contains(text(),'ADD TO CART')]");
    private static final By CART_ICON = By.cssSelector("img[alt='Cart']");
    private static final By PROCEED_TO_CHECKOUT = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private static final By PROMO_CODE_INPUT = By.className("promoCode");
    private static final By PROMO_BUTTON = By.className("promoBtn");
    private static final By PROMO_INFO = By.cssSelector(".promoInfo");
    
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void addItemToCart() {
        click(ADD_TO_CART_BUTTON);
    }
    
    public void openCart() {
        click(CART_ICON);
    }
    
    public void proceedToCheckout() {
        click(PROCEED_TO_CHECKOUT);
    }
    
    public void enterPromoCode(String promoCode) {
        sendKeys(PROMO_CODE_INPUT, promoCode);
    }
    
    public void applyPromoCode() {
        click(PROMO_BUTTON);
    }
    
    public String getPromoInfoText() {
        return getText(PROMO_INFO);
    }
    
    public boolean isPromoInfoDisplayed() {
        return waitHelper.waitForVisibilityOfElement(PROMO_INFO).isDisplayed();
    }
}
