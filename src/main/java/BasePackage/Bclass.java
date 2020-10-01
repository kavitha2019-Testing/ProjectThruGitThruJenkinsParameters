package BasePackage;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class Bclass {
    public WebDriver driver;
 // opening browser
    @BeforeMethod
    public void browseropen() {
        if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);
        } else if (System.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            driver = new FirefoxDriver(options);
        } else if (System.getProperty("browser").equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
//                                  options.addArguments("enable-automation");
//                                  options.addArguments("--no-sandbox");
//                                   options.addArguments("--disable-infobars");
//                                   options.addArguments("--disable-dev-shm-usage");
//                                   options.addArguments("--disable-browser-side-navigation");
//                                   options.addArguments("--disable-gpu");
           driver = new InternetExplorerDriver(options);
       }
            driver.get("https://www.hotukdeals.com/?page=4");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.MILLISECONDS);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
        }
        @AfterMethod
    public void teardown() {
        driver.close();
    }
}