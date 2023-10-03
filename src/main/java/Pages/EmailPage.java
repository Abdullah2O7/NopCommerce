package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{
    public EmailPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="FriendEmail")
    WebElement emailFriendTxt;

    @FindBy(id="PersonalMessage")
    WebElement messageTxt;

    @FindBy(name = "send-email")
    WebElement sendBtn;

    @FindBy(css="div.result")
    public WebElement messageSentSuccessfully;
    public void sendEmailToFriend(String friendEmail,String personalMessage)
    {
        SendText(emailFriendTxt,friendEmail);
        SendText(messageTxt,personalMessage);
        clickBtn(sendBtn);
    }
}
