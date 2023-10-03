package steps;

import Pages.HomePage;
import Pages.RegistrationPage;
import Tests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class userregistration extends TestBase {

    HomePage home;
    RegistrationPage registration;
    @Given("the user is in the home page")
    public void the_user_is_in_the_home_page() {
      home= new HomePage(driver);
      home.OpenRegistrationPage();
    }
    @When("Clicking on register link")
    public void clicking_on_register_link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }
    @When("Entering the user data")
    public void entering_the_user_data() {
    registration=new RegistrationPage(driver);
    registration.RegistrationForm("nb","km","nb@gmail.com","123456");
    }
    @Then("the registration page displayed successfully")
    public void the_registration_page_displayed_successfully() {
    home.Logout();
    }

}
