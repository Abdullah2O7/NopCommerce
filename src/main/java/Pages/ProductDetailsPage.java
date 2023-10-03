package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//strong[@class='current-item']")
    public WebElement checkProductName;
    @FindBy(xpath = "//button[@class='button-2 email-a-friend-button']")
    WebElement emailFriendBtn;
    @FindBy(id="price-value-4")
    public WebElement productPrice;
    @FindBy(linkText = "Add your review")
    WebElement reviewLink;
    @FindBy (id = "add-to-wishlist-button-4")
    WebElement AddToWishlist ;
    @FindBy (css ="p.content")
    public WebElement NotificationSuccess;
    @FindBy(xpath = "(//button[@class='button-2 add-to-compare-list-button'])[1]")
    WebElement addToCompareBtn;
     @FindBy(id="add-to-cart-button-4")
     WebElement addToCartBtn;
    public void OpenSendEmail()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickBtn(emailFriendBtn);
    }
    public void OpenAddReviewPage()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickBtn(reviewLink);
    }
    public void addProductToWishList()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickBtn(AddToWishlist);
    }
    public void AddProductToCompare()
    {
        clickBtn(addToCompareBtn);
    }
    public void addToCart(){clickBtn(addToCartBtn);}

}
