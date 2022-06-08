package stepDefinitions;

import POMs.LoginPagePOM;
import POMs.ProductsPagePOM;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Context;
import helpers.DriverHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {

    private final WebDriver driver;
    private final Context context;


    public LoginPageSteps() {
        this.driver=DriverHelper.getDriver ();
        this.context=new Context ();
    }

    @Given("a user is on the login page")
    public void aUserIsInLoginPage() {
        LoginPagePOM loginPagePOM=new LoginPagePOM ( driver );
        context.loginPagePOM=loginPagePOM;
        loginPagePOM.load ();
        loginPagePOM.isLoaded ();
        context.driver=driver;
        driver.close ();
    }

    @When("the client enters Credentials and press Login button")
    public void theClientEntersCredentialsAndPressLoginButton() {
        context.loginPagePOM.loginUserField();;
    }

    @Then("the client is successfully redirected to shop page")
    public void theUserIsSuccessfullyRedirectedToShopPage() {
        ProductsPagePOM productsPagePOM=new ProductsPagePOM ( context.driver );
        Assert.assertEquals ( "The page title is not the expected one" ,
                "Products".toLowerCase () , productsPagePOM.getPageTitle ().toLowerCase () );
    }

    @When("the user enters invalid {string} credentials and press Login button")
    public void theUserEntersInvalidCredentialsAndPressLoginButton(String credentials) {
        String username = credentials.split(",")[0];
        String password = credentials.split(",")[1];
        context.loginPagePOM.loginUserField (username, password);
    }

    @Then("the alert {string} message should displayed on the screen")
    public void theAlertMessageShouldDisplayedOnTheScreen(String alertMessage) {
        Assert.assertEquals ( String.format ( "The Error message is %s, but should be %s." ,
                        context.loginPagePOM.getAlertMessage () , alertMessage ) ,
                alertMessage , context.loginPagePOM.getAlertMessage () );
        driver.close ();
    }

}

//        @Given("there is a user with the following data:")
//        public void complexUser(DataTable table){
//            List<Map<String, String>> userData=table.asMaps(String.class, String.class);
//
//            for(Map<String, String> map:userData){
//                System.out.println(map.get("username"));
//                System.out.println(map.get("password"));
//                System.out.println(map.get("message"));
//            }
//        }
//        @When("the user fills the registration form with appropriate data")
//        public void userFillsCredentials() throws InterruptedException {
//            driver = DriverHelper.getDriver();
//            LoginPagePOM loginPagePOM=new LoginPagePOM(driver);
//
//            loginPagePOM.load();
//            loginPagePOM.isLoaded();
//            loginPagePOM.loginUserField(context.username, "secret_sauce");
//        }
//        @When("provide right username: {string} and password: {string} and press login")
//        public void pEnterUsernameAndPassword(DataTable table) {
//            List < Map <String, String> > userData=table.asMaps(String.class, String.class);
//
//            for(Map<String, String> map:userData){
//                System.out.println(map.get("username"));
//                System.out.println(map.get("password"));
//                System.out.println(map.get("message"));
//        }
//

