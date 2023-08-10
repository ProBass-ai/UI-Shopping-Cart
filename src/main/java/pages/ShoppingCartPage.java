package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestHelper;

import java.time.Duration;

public class ShoppingCartPage {
    private WebDriver driver;
    private By byNumberOfProductsFound = By.xpath("//main/main/p");
    private By byCartSidePanel = By.xpath("//div[@title='Products in cart quantity']/parent::div");
    private By getBySizeFilter(String sizeToFilterBy){
        return By.xpath("//h4[text()='Sizes:']/following-sibling::div/label/span[text()='" + sizeToFilterBy + "']");
    }
    private By getByAddClothingToCart(String itemName){
        return By.xpath("//div[@alt='" + itemName + "']/following-sibling::button[text()='Add to cart']");
    }


    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnSizeFilter(String sizeFilter){
        TestHelper.click(this.driver, getBySizeFilter(sizeFilter));
    }

    public String getNumberOfProductsFound(){
        return driver.findElement(byNumberOfProductsFound).getText();
    }

    public boolean isNumberOfProducts(String quantity){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.textToBe(byNumberOfProductsFound, quantity + " Product(s) found"));
    }


}
