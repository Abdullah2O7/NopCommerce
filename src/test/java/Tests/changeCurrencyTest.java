package Tests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class changeCurrencyTest extends TestBase{
     HomePage homePage;
     ProductDetailsPage detailsPage;
     SearchPage searchPage;
    String searchText="mac";
    String productName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void ChangeCurrency()
    {
        homePage=new HomePage(driver);
        homePage.changeCurrency();
    }
    @Test(priority = 2)
    public void SearchWithAutoSuggest()
    {
        try {
            searchPage =new SearchPage(driver);
            searchPage.ProductSearchByAutoSuggestion(searchText);
            detailsPage =new ProductDetailsPage(driver);

            Assert.assertTrue(detailsPage.checkProductName.getText().equalsIgnoreCase(productName));
            Assert.assertTrue(detailsPage.productPrice.getText().contains("€"));
            System.out.println(detailsPage.productPrice.getText());
        }catch(Exception e)
        {
            System.out.println("Error occurred "+e.getMessage());
        }

    }
}
