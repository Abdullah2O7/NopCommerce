package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToShoppingCartPage extends PageBase{
    public AddProductToShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "Button.remove-btn")
    WebElement RemoveButton ;

    @FindBy (id ="updatecart")
    WebElement updatecartButton;

    @FindBy (css = "input.qty-input")
    WebElement quantityText ;

    @FindBy (css = "span.product-subtotal")
    public WebElement total ;

    @FindBy (css ="a.product-name")
    public WebElement ProductNameResult;

    @FindBy (css ="div.no-data")
    public WebElement Result ;

    @FindBy (id = "checkout")
    WebElement checkoutButton ;

    @FindBy (id ="termsofservice")
    WebElement AgreeCheckbox ;

    @FindBy (css ="div.page-title")
    public WebElement pageTitleChechout ;

    public void RemoveProductFromCart () {

        clickBtn(RemoveButton);

    }
    public void UpdateProductQuantityCart (String quantityProduct) {
        // Clear Quantity TextBox
        quantityText.clear();
        SendText(quantityText, quantityProduct);
        clickBtn(updatecartButton);
    }
    public void OpenCheckoutPage() {
        clickBtn(AgreeCheckbox);
        clickBtn(checkoutButton);

    }
}
