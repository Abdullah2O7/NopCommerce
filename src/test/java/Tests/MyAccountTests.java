package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTests extends TestBase{
    private HomePage homePage;
    RegistrationPage registrationPage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    Faker fakeData = new Faker();
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(6);

    String newPassword = fakeData.number().digits(6);
    @Test(priority = 1)
    public void ValidRegistration()
    {
        homePage = new HomePage(driver);
        homePage.OpenRegistrationPage();
        registrationPage = new RegistrationPage(driver);
        registrationPage.RegistrationForm(firstName,lastName,email,password);
        Assert.assertTrue(registrationPage.SuccessfulRegister.getText().contains("Your registration completed"));
    }
    @Test(dependsOnMethods ="ValidRegistration")
    public void RegisteredUserCanLogin()
    {
        homePage.OpenLoginPage();
        loginPage =new LoginPage(driver);
        loginPage.LoginForm(email,password);
        Assert.assertTrue(homePage.logoutLink.isDisplayed());
    }
    @Test(dependsOnMethods = "RegisteredUserCanLogin")
    public void LoginUserCanChangePassword()
    {
        homePage.OpenMyAccountPage();
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.OpenChangePasswordPage();
        myAccountPage.changePassword(password,newPassword);
        Assert.assertTrue(myAccountPage.successfulChange.getText().contains(" was changed"));
    }
    @Test(dependsOnMethods = "LoginUserCanChangePassword")
    public void closeTheNotificationBar()
    {

        myAccountPage.CloseNotification();
    }
    @Test(dependsOnMethods = "closeTheNotificationBar")
    public void RegisteredUserCanLogout()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.Logout();
    }

    @Test(dependsOnMethods ="RegisteredUserCanLogout")
    public void UserCanLoginWithNewPassword()
    {
        homePage.OpenLoginPage();
        loginPage =new LoginPage(driver);
        loginPage.LoginForm(email,newPassword);
        Assert.assertTrue(homePage.logoutLink.isDisplayed());
    }


}
