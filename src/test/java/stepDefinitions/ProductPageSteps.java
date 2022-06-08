package stepDefinitions;

import POMs.CartPOM;
import POMs.CheckoutPOM;
import POMs.LoginPagePOM;
import POMs.ProductsPagePOM;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Context;
import helpers.DriverHelper;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class ProductPageSteps {
    private WebDriver driver;
    private Context context;

    public ProductPageSteps() {
        driver=DriverHelper.getDriver ( );
        this.context=new Context ( );
    }

    @Given("the logged client is on the products page")
    public void userProductPage() {
        context.driver = driver;
        context.loginPagePOM = new LoginPagePOM (context.driver);
        context.productsPagePOM = new ProductsPagePOM (context.driver);
        context.loginPagePOM.load();
        context.loginPagePOM.loginUserField ();
        context.productsPagePOM.isLoaded();
    }

    @And("the client add the following items to the cart:")
    public void theUserAddsTheFollowingItemsToTheCart(DataTable dataTable) throws InterruptedException {
        Map<String, String> items = dataTable.asMaps().get(0);
        for (String key : items.keySet()) {
            String itemName = items.get(key);
            if (itemName != null && !itemName.trim().equals("")) {
                context.productsPagePOM.selectAddToCartButton(itemName);
            }
        }
        context.items = items;
    }

    @And("the client navigates to the Checkout Page")
    public void checkoutPage() {
        context.productsPagePOM.GoToCart() ;
        CartPOM cartPOM= new CartPOM ( context.driver );
        cartPOM.clickCheckoutButton();
        cartPOM.clickContinueButton ();
        driver.close ();
    }

    @Then("all items are successfully added")
    public void all_items_are_successfully_added() {
        CheckoutPOM checkoutPOM = new CheckoutPOM(context.driver);
        Map < String, String > productExpect=context.productsTitles;
        for (String key : productExpect.keySet ( )) {
            String productTitle=productExpect.get ( key );
            if (!productTitle.equals ( "" )) {
                Assert.assertTrue ( String.format ( "Product with title %s is not added to the cart" , productTitle ) ,
                        context.checkoutPOM.doesItemExist ( productTitle ) );
            }
        }
    }

    @When("the client selects {string} sorting")
    public void SortingSelect(String sorting) {
        context.products = context.productsPagePOM.getProducts(sorting);
        context.productsPagePOM.SortingSelect ( sorting );
    }

}
