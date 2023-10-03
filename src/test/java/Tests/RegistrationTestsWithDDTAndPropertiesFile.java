package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import data.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTestsWithDDTAndPropertiesFile extends TestBase{
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    String firstName = LoadProperties.userData.getProperty("firstName");
    String lastName = LoadProperties.userData.getProperty("lastName");
    String email = LoadProperties.userData.getProperty("email");
    String pass = LoadProperties.userData.getProperty("password");

    @Test(priority = 1)
    public void ValidRegistration()
    {
        homePage = new HomePage(driver);
        homePage.OpenRegistrationPage();
        registrationPage = new RegistrationPage(driver);
        registrationPage.RegistrationForm(firstName,lastName,email,pass);
        Assert.assertTrue(registrationPage.SuccessfulRegister.getText().contains("Your registration completed"));
    }
    @Test(priority = 2,dependsOnMethods ="ValidRegistration")
    public void RegisteredUserCanLogin()
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
