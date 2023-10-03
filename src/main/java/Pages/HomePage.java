package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }
    @FindBy(className="ico-register")
    WebElement registerLink;
    @FindBy(className = "ico-login")
    WebElement loginLink;
    @FindBy(linkText = "My account")
    WebElement MyAccountLink;
    @FindBy(className = "ico-logout")
    public WebElement logoutLink;
    @FindBy(linkText = "Contact us")
    WebElement ContactUsLink;
    @FindBy(xpath = "//select[@name='customerCurrency']")
    WebElement currencyDl;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
    WebElement computerMenu;
    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
    WebElement NoteBooksMenu;

    public void OpenRegistrationPage()
    {
        clickBtn(registerLink);
    }
    public  void OpenLoginPage()
    {
        clickBtn(loginLink);
    }
  public void OpenMyAccountPage(){ clickBtn(MyAccountLink); }
    public void Logout()
    {
        clickBtn(logoutLink);
    }

    public void OpenContactUsPage()
    {
        scrollToBottom();
        clickBtn(ContactUsLink);
    }
   public void changeCurrency()
   {
        select=new Select(currencyDl);
        select.selectByVisibleText("Euro");
   }
   public void SelectNoteBooksMenu()
   {
       action.moveToElement(computerMenu).moveToElement(NoteBooksMenu).click().build().perform();
   }
}
