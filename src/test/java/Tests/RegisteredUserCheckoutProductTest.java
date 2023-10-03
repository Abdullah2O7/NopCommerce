package Tests;

import Pages.*;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisteredUserCheckoutProductTest extends TestBase{
    HomePage homePage;
    SearchPage searchPage;
    ProductDetailsPage detailsPage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    OrderDetailsPage orderPage;
    AddProductToShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    String ProductName = "Apple MacBook Pro 13-inch" ;
    Faker fakeData = new Faker();
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(6);
    String code = fakeData.number().digits(6);
    String phone = fakeData.phoneNumber().phoneNumber();
    String address = fakeData.name().name();
    String City = "cairo" ;

    @Test(priority = 1)
    public void ValidRegistration()
    {
        homePage = new HomePage(driver);
        homePage.OpenRegistrationPage();
        registrationPage = new RegistrationPage(driver);
        registrationPage.RegistrationForm(firstName,lastName,email,password);
        Assert.assertTrue(registrationPage.SuccessfulRegister.getText().contains("Your registration completed"));
    }
    @Test(priority = 2, dependsOnMethods ="ValidRegistration")
        public void RegisteredUserCanLogin()
        {
            homePage.OpenLoginPage();
            loginPage =new LoginPage(driver);
            loginPage.LoginForm(email,password);
            Assert.assertTrue(homePage.logoutLink.isDisplayed());
        }
    @Test(priority = 2)
    public void searchAboutProduct()
    {
        searchPage = new SearchPage(driver);
        searchPage.Search(ProductName);
        searchPage.OpenProductDetailsPage();
        detailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(detailsPage.checkProductName.getText().equalsIgnoreCase(ProductName));
    }
    @Test (priority = 3 )
    public void UserCanAddToCart () {
        detailsPage = new ProductDetailsPage(driver);
        detailsPage.addToCart();
        driver.navigate().to("https://demo.nopcommerce.com/cart");
        shoppingCartPage =new AddProductToShoppingCartPage(driver);
        Assert.assertTrue(shoppingCartPage.ProductNameResult.getText().contains("Apple MacBook Pro 13-inch"));

    }
    @Test (priority = 4)
    public void UserClickCheckout ()  {
        shoppingCartPage= new AddProductToShoppingCartPage(driver);
        shoppingCartPage.OpenCheckoutPage();
        Assert.assertTrue(shoppingCartPage.pageTitleChechout.isDisplayed());
    }
    @Test (priority = 5)
    public void UserCanCheckout () throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.CheckoutProduct( City, address, code, phone);
        //Assert.assertTrue(checkoutPage.productName.getText().contains("Apple MacBook Pro 13-inch"));
    }
    @Test (priority = 6)
    public void UserCanConfirmedOrder () throws InterruptedException {
        checkoutPage = new CheckoutPage(driver) ;
        checkoutPage.ConfirmOrder();
        Assert.assertTrue(checkoutPage.SuccessMessage.isDisplayed());
        checkoutPage.clickOrderDetails();
        Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
        orderPage = new OrderDetailsPage(driver);
        orderPage.DownloadPDFInvoice();
        orderPage.PrintOrderDetails();

    }

}
