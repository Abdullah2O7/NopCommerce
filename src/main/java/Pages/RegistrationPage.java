package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id="LastName")
    WebElement lastName;

    @FindBy( id= "gender-male")
    WebElement genderRadioBtn;
    @FindBy(id="Email")
    WebElement email;

    @FindBy(id="Password")
    WebElement password;
    @FindBy(id="ConfirmPassword")
    WebElement confirmPassword;

   @FindBy(id="register-button")
    WebElement registerButton;

   @FindBy(className = "result")
   public WebElement SuccessfulRegister;




   public void RegistrationForm(String fName,String lName,String mail,String pass)
   {
         clickBtn(genderRadioBtn);
         SendText(firstName,fName);
         SendText(lastName,lName);
         SendText(email,mail);
         SendText(password,pass);
         SendText(confirmPassword,pass);
         clickBtn(registerButton);
   }

}
