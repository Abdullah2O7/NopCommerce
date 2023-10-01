package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTestsWithJavaFaker extends TestBase{
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    Faker fakeData = new Faker();
    String firstName=fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password =  fakeData.number().digits(8).toString();

    @Test(priority = 1)
    public void ValidRegistration()
    {
        homePage = new HomePage(driver);
        homePage.OpenRegistrationPage();
        registrationPage = new RegistrationPage(driver);
        registrationPage.RegistrationForm(firstName,lastName,email,password);
        Assert.assertTrue(registrationPage.SuccessfulRegister.getText().contains("Your registration completed"));
    }
    @Test(priority = 2,dependsOnMethods ="ValidRegistration")
    public void RegisteredUserCanLogin()
    {
        homePage.OpenLoginPage();
        loginPage =new LoginPage(driver);
        loginPage.LoginForm(email,password);
        Assert.assertTrue(homePage.logoutLink.isDisplayed());
    }
    @Test(priority = 3,dependsOnMethods = "RegisteredUserCanLogin")
    public void RegisteredUserCanLogout()
    {
        homePage.Logout();
    }

}
