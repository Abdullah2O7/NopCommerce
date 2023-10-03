package Tests;

import Utilities.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class TestBase extends AbstractTestNGCucumberTests {
    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browserName)
    {
        if(browserName.equalsIgnoreCase( "chrome"))
        {
            driver =new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        // Chrome headless
        else if(browserName.equalsIgnoreCase("chrome-headless"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterClass
    public void quite() {
       driver.quit();
   }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed\n Taking Screenshot.....");
            Helper.captureScreenshot(driver,result.getName());
        }
    }

}
