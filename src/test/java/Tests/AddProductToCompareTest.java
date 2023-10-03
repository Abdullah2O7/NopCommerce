package Tests;

import Pages.AddProductToComparePage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCompareTest extends TestBase{
     String firstProName="Apple MacBook Pro 13-inch";
     String secondProName="Ray Ban Aviator Sunglasses";
     HomePage homepage;
     ProductDetailsPage detailsPage;
     SearchPage searchPage;
     AddProductToComparePage comparePage;
     @Test(priority = 1)
     public void AddProduct1()
     {
         searchPage =new SearchPage(driver);
         detailsPage =new ProductDetailsPage(driver);

         searchPage.Search(firstProName);
         searchPage.OpenProductDetailsPage();
         Assert.assertTrue(detailsPage.checkProductName.getText().equalsIgnoreCase(firstProName));
         detailsPage.AddProductToCompare();
     }
     @Test(priority = 2)
     public void AddProduct2()
     {
         searchPage =new SearchPage(driver);
         searchPage.Search("Ray Ban Aviator Sunglasses");
         searchPage.OpenProductDetailsPage();
         detailsPage =new ProductDetailsPage(driver);
         //Assert.assertTrue(detailsPage.checkProductName.getText().equalsIgnoreCase("Ray Ban Aviator Sunglasses"));
         detailsPage.AddProductToCompare();
     }
     @Test(priority = 3)
     public void UserCanCompareProducts() throws InterruptedException
     {
         driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
         Assert.assertTrue(comparePage.firstProductName.isDisplayed());
         //Assert.assertTrue(comparePage.secondProductName.equals("Ray Ban Aviator Sunglasses"));
         comparePage=new AddProductToComparePage(driver);
         comparePage.compareProducts();
     }
     @Test(priority = 4)
    public void UserCanClearCompareList()
     {
         comparePage=new AddProductToComparePage(driver);
         comparePage.clearCompareTable();
     }
}
