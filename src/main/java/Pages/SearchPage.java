package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase {

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="small-searchterms")
    WebElement searchBox;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    WebElement searchBtn;

    @FindBy(id="ui-id-2")
    List<WebElement> autoSuggest ;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement findProTitle;

    public void Search(String proName)
    {
         SendText(searchBox,proName);
         clickBtn(searchBtn);
    }
    public void OpenProductDetailsPage()
    {
        clickBtn(findProTitle);
    }
    public void ProductSearchByAutoSuggestion(String searchTxt)  {
        SendText(searchBox,searchTxt);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        autoSuggest.get(0).click();
    }

}
