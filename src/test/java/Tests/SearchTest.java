package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
 SearchPage searchPage;
 ProductDetailsPage productDetailsPage;
    String productName = "Apple MacBook Pro 13-inch";

    @Test
    public void searchAboutProduct()
    {
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        searchPage.Search(productName);
        searchPage.OpenProductDetailsPage();
        Assert.assertTrue(productDetailsPage.checkProductName.getText().equalsIgnoreCase(productName));

    }
}
