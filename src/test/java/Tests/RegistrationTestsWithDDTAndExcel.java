package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTestsWithDDTAndExcel extends TestBase{
    private HomePage homePage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    String mail = "klam2@gmail.com";
    String pass = "1234567";

    @DataProvider(name = "ExcelData")
     public Object[][] userRegisterData() throws IOException {
        // get data from Excel reader class
        ExcelReader ER = new ExcelReader();
            return ER.getExcelData();
    }
    @Test(priority = 1,dataProvider = "ExcelData")
    public void ValidRegistration(String Fname,String lname,String email,String password)
    {
        homePage = new HomePage(driver);
        homePage.OpenRegistrationPage();
        registrationPage = new RegistrationPage(driver);
        registrationPage.RegistrationForm(Fname, lname, email, password);
        Assert.assertTrue(registrationPage.SuccessfulRegister.getText().contains("Your registration completed"));
    }
    // We should create an Excel sheet for the login method
    @Test(priority = 2,dependsOnMethods ="ValidRegistration")
    public void RegisteredUserCanLogin()
    {
        homePage.OpenLoginPage();
        loginPage =new LoginPage(driver);
        loginPage.LoginForm(mail,pass);
        Assert.assertTrue(homePage.logoutLink.isDisplayed());
    }
    @Test(priority = 3,dependsOnMethods = "RegisteredUserCanLogin")
    public void RegisteredUserCanLogout()
    {
        homePage.Logout();
    }

}
