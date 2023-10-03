package Tests;

import Pages.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFriendTest extends TestBase {

private HomePage homePage;
     RegistrationPage registrationPage;
     LoginPage loginPage;
     SearchPage searchPage;
    private ProductDetailsPage productDetailsPage;
    EmailPage emailPage;
    Faker fakeData = new Faker();
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(6);
    String searchText="mac";
    String productName = "Apple MacBook Pro 13-inch";

    // 1- User Registration
    @Test(priority = 1)
    public void ValidRegistration()
    {
        homePage = new HomePage(driver);
        homePage.OpenRegistrationPage();
        registrationPage = new RegistrationPage(driver);
        registrationPage.RegistrationForm(firstName,lastName,email,password);
        Assert.assertTrue(registrationPage.SuccessfulRegister.getText().contains("Your registration completed"));
   }
    @Test(priority = 2)
    public void RegisteredUserCanLogin()
    {
        homePage.OpenLoginPage();
        loginPage =new LoginPage(driver);
        loginPage.LoginForm(email,password);
        Assert.assertTrue(homePage.logoutLink.isDisplayed());
    }

    // 2-Search for product
    @Test(priority = 3)
    public void SearchWithAutoSuggest()
    {
        try {
            searchPage =new SearchPage(driver);
            searchPage.ProductSearchByAutoSuggestion(searchText);
            productDetailsPage =new ProductDetailsPage(driver);
            Assert.assertTrue(productDetailsPage.checkProductName.getText().equalsIgnoreCase(productName));
        }catch(Exception e)
        {
            System.out.println("Error occurred "+e.getMessage());
        }

    }

    // 3-Send Email
    @Test(priority = 4)
    public void LoginUserCanSendEmailToFriend()
    {
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.OpenSendEmail();
        emailPage= new EmailPage(driver);
        emailPage.sendEmailToFriend("kn@gmail.com","this is a very good product");
        Assert.assertTrue(emailPage.messageSentSuccessfully.getText().contains("has been sent"));
    }
}