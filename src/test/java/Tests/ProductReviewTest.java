package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductReviewTest extends TestBase{
/*
  1- Registration
  2- Login
  3- Search for product
  4- Add Review
 */
private HomePage homePage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    String Fname="abdallah";
    String lname="Mohamed";
    String mail = "mha63@gmail.com";
    String pass = "123456";
    @Test(priority = 1)
    public void ValidRegistration()
    {
        homePage = new HomePage(driver);
        homePage.OpenRegistrationPage();
        registrationPage = new RegistrationPage(driver);
        registrationPage.RegistrationForm(Fname,lname,mail,pass);
        Assert.assertTrue(registrationPage.SuccessfulRegister.getText().contains("Your registration completed"));
    }
    @Test(priority = 2)
    public void RegisteredUserCanLogin()
    {
        homePage = new HomePage(driver);
        homePage.OpenLoginPage();
        loginPage =new LoginPage(driver);
        loginPage.LoginForm(mail,pass);
        Assert.assertTrue(homePage.logoutLink.isDisplayed());
    }
    private SearchPage searchPage;
    private ProductDetailsPage productDetailsPage;
    String searchText="mac";
    String productName = "Apple MacBook Pro 13-inch";
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
    ProductReviewPage reviewPage;
    String title="Good Product";
    String message="I recommend this product for everyone";
    @Test(priority = 4)
    public void UserCanAddReview()
    {
        productDetailsPage =new ProductDetailsPage(driver);
        productDetailsPage.OpenAddReviewPage();
        reviewPage =new ProductReviewPage(driver);
        reviewPage.AddProductReview(title,message);
        Assert.assertTrue(reviewPage.reviewNotification.getText().contains("successfully added"));
    }
}
