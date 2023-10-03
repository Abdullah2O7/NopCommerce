package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HoverMenuTest extends TestBase{

    HomePage homePage;
    @Test
    public void SelectSubcategoryFromMainMenu()
    {
        homePage = new HomePage(driver);
        homePage.SelectNoteBooksMenu();
        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }
}
