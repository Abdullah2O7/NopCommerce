package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{
    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@class='review-title']")
    WebElement reviewTitleTxt;
    @FindBy(id="AddProductReview_ReviewText")
    WebElement reviewText;
    @FindBy(id="addproductrating_4")
    WebElement ratingBtn;
    @FindBy(name="add-review")
    WebElement submitBtn;
    @FindBy(css="div.result")
    public WebElement reviewNotification;

    public void AddProductReview(String reviewTitle,String reviewMessage)
    {
        SendText(reviewTitleTxt,reviewTitle);
        SendText(reviewText,reviewMessage);
        clickBtn(ratingBtn);
        clickBtn(submitBtn);
    }
}
