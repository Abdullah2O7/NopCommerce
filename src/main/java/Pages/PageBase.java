package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
   protected WebDriver driver;
   public JavascriptExecutor jse;
   public Select select;
   public Actions action;

public PageBase(WebDriver driver)
{
     PageFactory.initElements(driver,this); //this.driver=driver;
}
public static void clickBtn(WebElement element)
{
    element.click();
}
public static void SendText(WebElement element,String text)
{
    element.sendKeys(text);
}
public void scrollToBottom()
{
jse.executeScript("scrollBy(0,2500)");
}

}
