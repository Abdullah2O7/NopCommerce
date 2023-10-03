package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToWishListPage extends PageBase{
    public AddProductToWishListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "button.remove-btn")
    WebElement ButtonRemove ;

    @FindBy (css = "div.no-data")
    public WebElement EmptyWishlist ;

    @FindBy (css = "div.page-title")
    public WebElement PageTitleWishlist;

    public void removeProductFromWishList()
    {
        clickBtn(ButtonRemove);

    }
}
