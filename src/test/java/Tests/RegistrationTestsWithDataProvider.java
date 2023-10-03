package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTestsWithDataProvider extends TestBase{
    private HomePage homePage;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @DataProvider(name = "TestData")
    public static Object[][] userData()
    {
        return new Object[][]{
                {"Abdallah","Mohamed","test4@gmail.com","123456"}
        };
    }
    @DataProvider(name = "LoginData")
    public static Object[][] loginData()
    {
        return new Object[][]{
                {"test4@gmail.com","123456"}
        };
    }
    @Test(priority = 1,dataProvider = "TestData")
    public void ValidRegistration(String fname,String Lname,String email,String pass)
    {
        homePage = new HomePage(driver);
        homePage.OpenRegistrationPage();
        registrationPage = new RegistrationPage(driver);
        registrationPage.RegistrationForm(fname, Lname, email, pass);
        Assert.assertTrue(registrationPage.SuccessfulRegister.getText().contains("Your registration completed"));
    }
    @Test(priority = 2,dependsOnMethods ="ValidRegistration",dataProvider = "LoginData")
    public void RegisteredUserCanLogin(String email,String pass)
    {
        homePage.OpenLoginPage();
        loginPage =new LoginPage(driver);
        loginPage.LoginForm(email,pass);
        Assert.assertTrue(homePage.logoutLink.isDisplayed());
    }
    @Test(priority = 3,dependsOnMethods = "RegisteredUserCanLogin")
    public void RegisteredUserCanLogout()
    {
        homePage.Logout();
    }

}
