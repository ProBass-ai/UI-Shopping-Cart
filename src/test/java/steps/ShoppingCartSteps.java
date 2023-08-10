package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.ShoppingCartPage;

import static junit.framework.TestCase.assertTrue;

public class ShoppingCartSteps {
    private WebDriver driver;
    private ShoppingCartPage shoppingCartPage;

    @Given("the user is on the landing page")
    public void theUserIsOnTheHomePage(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        if(!System.getProperty("os.name").contains("Windows")){
            options.addArguments("--headless");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @When("the user items filters by {string}")
    public void theUserItemsFiltersBy(String sizeFilter) {
        shoppingCartPage.clickOnSizeFilter(sizeFilter);
    }

    @Then("the number if items found is {string}")
    public void theNumberIfItemsFoundIs(String expectedQuantity) {
        assertTrue(shoppingCartPage.isNumberOfProducts(expectedQuantity));
    }
}
