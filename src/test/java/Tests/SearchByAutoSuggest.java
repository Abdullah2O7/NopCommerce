package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByAutoSuggest extends TestBase{
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    String searchText="mac";
    String productName = "Apple MacBook Pro 13-inch";
    @Test
    public void SearchWithAutoSuggest()
    {
        try {
            searchPage =new SearchPage(driver);
            searchPage.ProductSearchByAutoSuggestion(searchText);
            productDetailsPage =new ProductDetailsPage(driver);
            Assert.assertTrue(productDetailsPage.checkProductName.getText().equalsIgnoreCase(productName));
        }catch(Exception e)
        {
            System.out.println("Error occurred "+e.getMessage());
        }

    }
}
