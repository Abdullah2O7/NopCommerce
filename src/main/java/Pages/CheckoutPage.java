package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement CountryList ;

    @FindBy (id = "BillingNewAddress_StateProvinceId")
    WebElement StateProvinceIdList ;

    @FindBy (id = "BillingNewAddress_City")
    public WebElement CityTxt ;


    @FindBy (id = "BillingNewAddress_Address1")
    WebElement Address1Txt ;

    @FindBy (id = "BillingNewAddress_ZipPostalCode")
    WebElement ZipPostalCodeTxt ;

    @FindBy (id = "BillingNewAddress_PhoneNumber")
    WebElement PhoneNumberTxt ;
    @FindBy (xpath = "(//input[@name='ShipToSameAddress'])[1]")
    WebElement shippingoptionRadiobutton;
    @FindBy (xpath = "(//button[@name='save'])[1]")
    WebElement ContnueButton1;



    @FindBy (xpath = "//button[@class='button-1 shipping-method-next-step-button']")
    WebElement ContinueShippingMethod;
    @FindBy (xpath =  "//button[@class='button-1 payment-method-next-step-button']")
    WebElement continuePaymentMethod;

    @FindBy (xpath = "//button[@class='button-1 payment-info-next-step-button']")
    WebElement ContnuePaymentInformation ;

    @FindBy (xpath = "//button[@class='button-1 confirm-order-next-step-button']")
    WebElement  confirmbutton;

    @FindBy (css ="a.product-name")
    public WebElement productName ;

    @FindBy (css ="div.page-title")
    public WebElement SuccessMessage ;

    @FindBy (linkText = "Click here for order details.")
    WebElement OrderDetailsLink ;


    public void CheckoutProduct ( String City , String Address1 ,String PostCode , String phone ) throws InterruptedException {

        select = new Select(CountryList);
        select.selectByVisibleText("United States");
        Thread.sleep(1000);
        select=new Select(StateProvinceIdList);
        select.selectByVisibleText("Alaska");
        SendText(CityTxt, City);
        SendText(Address1Txt, Address1);
        SendText(ZipPostalCodeTxt, PostCode);
        SendText(PhoneNumberTxt, phone);
        clickBtn(ContnueButton1);

        Thread.sleep(1000);
       clickBtn(ContinueShippingMethod);
        Thread.sleep(1000);
        clickBtn(continuePaymentMethod);
        Thread.sleep(1000);
        clickBtn(ContnuePaymentInformation);
        Thread.sleep(1000);

    }
    public  void ConfirmOrder() throws InterruptedException {
        Thread.sleep(1000);
        clickBtn(confirmbutton);
        Thread.sleep(2000);
    }

    public void clickOrderDetails() {
        clickBtn(OrderDetailsLink);
    }

}
