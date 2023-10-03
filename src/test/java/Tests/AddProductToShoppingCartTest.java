package Tests;

import Pages.AddProductToShoppingCartPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToShoppingCartTest extends TestBase{
    SearchPage searchPage;
    ProductDetailsPage detailsPage;
    AddProductToShoppingCartPage cartPage;
    String productName = "Apple MacBook Pro 13-inch" ;
    String quantityProductEdit = "4";


    @Test(priority = 1)
    public void UserCanSearch () throws InterruptedException  {
        searchPage = new SearchPage(driver);
        searchPage.Search(productName);
        searchPage.OpenProductDetailsPage();
        detailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(detailsPage.checkProductName.getText().equalsIgnoreCase(productName));
    }

    @Test (priority = 2 )
    public void UserCanAddToCart () {
        detailsPage = new ProductDetailsPage(driver);
        detailsPage.addToCart();
        driver.navigate().to("https://demo.nopcommerce.com/cart");
        cartPage =new AddProductToShoppingCartPage(driver);
        Assert.assertTrue(cartPage.ProductNameResult.getText().contains("Apple MacBook Pro 13-inch"));

    }

    @Test (priority = 3 )
    public void UserCanEditOfQuantityOfProduct () {
        cartPage = new AddProductToShoppingCartPage(driver);
        cartPage.UpdateProductQuantityCart(quantityProductEdit);
        Assert.assertTrue(cartPage.total.getText().contains("$7,200.00"));
    }
    @Test (priority = 4 )
    public void UserCanRemoveProduct () {

        cartPage.RemoveProductFromCart();
        Assert.assertTrue(cartPage.Result.getText().contains("Your Shopping Cart is empty!"));
    }
}
