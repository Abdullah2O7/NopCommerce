package Tests;

import Pages.AddProductToWishListPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToWishListTest extends TestBase{
    private SearchPage searchPage;
    private ProductDetailsPage productDetailsPage;
    AddProductToWishListPage wishListPage;
    String productName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void searchAboutProduct()
    {
        searchPage = new SearchPage(driver);
        searchPage.Search(productName);
        searchPage.OpenProductDetailsPage();
        productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(productDetailsPage.checkProductName.getText().equalsIgnoreCase(productName));

    }

    @Test(priority = 2)
    public void UserCanAddProductToWishList() throws InterruptedException
    {
        productDetailsPage=new ProductDetailsPage(driver);
        productDetailsPage.addProductToWishList();
        driver.navigate().to("https://demo.nopcommerce.com/wishlist");
        wishListPage=new AddProductToWishListPage(driver);
        //Assert.assertTrue(wishListPage.WishListHeader.getText().contains(productName));
    }
    @Test(priority = 3)
    public void UserCanRemoveProductFromCart()
    {
        wishListPage=new AddProductToWishListPage(driver);
        wishListPage.removeProductFromWishList();
        Assert.assertTrue(wishListPage.EmptyWishlist.getText().contains("empty"));
    }
}
