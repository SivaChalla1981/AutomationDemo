package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {

    public static WebDriver driver;
    //Environment Variable to refer in shell script
    static String environmentType = System.getProperty("environment", "local");
    //Browser variable to refer in shell script
    static String browserType = System.getProperty("browser", "chrome");


    @BeforeClass
    public static WebDriver getDriver()
    {
        System.out.println("Browser: " + browserType);

        switch (browserType.toLowerCase()) {
            case "ff":
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ch":
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//browsers//chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "ie" :
            case "internetexplorer":
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Invalid browser name "+browserType);
                System.exit(0);
                break;
        }//switch

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }
    @AfterClass
    public void closeBrowserInstance(){
        if(driver!=null)
            driver.close();
    }

}
