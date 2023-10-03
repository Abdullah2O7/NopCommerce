package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "email")
    WebElement EmailBtn;

    @FindBy(className = "password")
    WebElement passwordBtn;

   @FindBy(id = "RememberMe")
    WebElement rememberMeBtn;

   @FindBy(xpath = "(//button[@type='submit'])[2]")
    WebElement SubmitBtn;

   public void LoginForm(String mail,String pass)
   {
       SendText(EmailBtn,mail);
       SendText(passwordBtn,pass);
       clickBtn(rememberMeBtn);
       clickBtn(SubmitBtn);
   }
}
