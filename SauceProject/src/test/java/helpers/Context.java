package helpers;

import POMs.CartPOM;
import POMs.CheckoutPOM;
import POMs.LoginPagePOM;
import POMs.ProductsPagePOM;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class Context {
    public LoginPagePOM loginPagePOM;
    public ProductsPagePOM productsPagePOM;
    public CartPOM cartPOM;
    public WebDriver driver;
    public Map < String, String > productsTitles;
    public Map< String, String> items;
    public CheckoutPOM checkoutPOM;
    public List< String> products;
}
