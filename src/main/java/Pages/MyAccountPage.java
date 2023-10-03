package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;

    @FindBy(xpath = "//*[@id='OldPassword']")
    WebElement oldPasswordBtn;

    @FindBy(id="NewPassword")
    WebElement NewPasswordBtn;

    @FindBy(id="ConfirmNewPassword")
    WebElement confirmPasswordBtn;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    WebElement changePasswordBtn;

    @FindBy(xpath = "//p[@class='content']")
    public WebElement successfulChange;

    @FindBy(xpath = "//*[@id='bar-notification']/div/span")
    WebElement notification;

    public void OpenChangePasswordPage(){ clickBtn(changePasswordLink); }

    public void changePassword(String oldPassword,String newPassword)
    {
        SendText(oldPasswordBtn,oldPassword);
        SendText(NewPasswordBtn,newPassword);
        SendText(confirmPasswordBtn,newPassword);
        clickBtn(changePasswordBtn);

    }

public void CloseNotification()
{
    clickBtn(notification);
}
}
