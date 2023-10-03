package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddProductToComparePage extends PageBase{
    public AddProductToComparePage(WebDriver driver) {
        super(driver);
    }
   @FindBy(xpath = "//a[@class='clear-list']")
    WebElement clearListLink;
    @FindBy(xpath = "//table[@class='compare-products-table']")
    WebElement compareTable;
    @FindBy(tagName = "tr")
    public List<WebElement> allRows;
    @FindBy(tagName = "td")
    public List<WebElement> allCol;
    @FindBy(xpath = "//div[@class='no-data']")
    WebElement noData;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement firstProductName;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/a")
    public WebElement secondProductName;

     public void clearCompareTable()
     {
         clickBtn(clearListLink);
     }

     public void compareProducts()
     {
         // Get all Rows
         System.out.println(allRows.size());
         // Get all data from Rows
         for(WebElement row : allRows)
         {
             System.out.println(row.getText()+"\t");
             for(WebElement col:allCol)
             {
                 System.out.println(col.getText()+"\t");
             }
         }
     }
}
