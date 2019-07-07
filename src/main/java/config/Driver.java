package config;

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

public class Driver {

    public static WebDriver driver;
    //Environment Variable to refer in shell script
    static String environmentType = System.getProperty("environment", "local");
    //Browser variable to refer in shell script
    static String browserType = System.getProperty("browser", "firefox");


    @BeforeClass
    protected static WebDriver getDriver() {
        driver = null;
        if (driver == null) {

            if ("local".equalsIgnoreCase(environmentType)) {
                /**
                 * Firefox Driver capabilities
                 */
                if ("firefox".equalsIgnoreCase(browserType)) {

                    DesiredCapabilities capability = DesiredCapabilities.firefox();

                    try {
                        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//browsers//geckodriver.exe");
                        driver = new FirefoxDriver(capability);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                /**
                 * Chromedriver Capabilites
                 */
                if ("chrome".equalsIgnoreCase(browserType)) {
                    DesiredCapabilities capability = DesiredCapabilities.chrome();
                    try {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//browsers//chromedriver.exe");
                        driver = new ChromeDriver(capability);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                /**
                 * Chromedriver Capabilites
                 */
                if ("ie".equalsIgnoreCase(browserType)) {
                    DesiredCapabilities capability = DesiredCapabilities.chrome();
                    try {
                        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//browsers//ie.exe");
                        driver = new InternetExplorerDriver(capability);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

               /* *//**
                 * Html UnitDriver
                 *//*
                if ("htmlunit".equalsIgnoreCase(browserType)) {
                    driver = new HtmlUnitDriver();
                }*/

            }
            else {

                if ("qa".equalsIgnoreCase(environmentType)) {
                    /**
                     * Firefox Driver capabilities
                     */
                    if ("firefox".equalsIgnoreCase(browserType)) {
                        DesiredCapabilities capability = DesiredCapabilities.firefox();
                        try {


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    /**
                     * Chromedriver Capabilites
                     */
                    if ("chrome".equalsIgnoreCase(browserType)) {
                        DesiredCapabilities capability = DesiredCapabilities.chrome();
                        try {
                            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//browsers//chromedriver.exe");
                            driver = new ChromeDriver(capability);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

               /* *//**
                     * Html UnitDriver
                     *//*
                if ("htmlunit".equalsIgnoreCase(browserType)) {
                    driver = new HtmlUnitDriver();
                }*/

                }

            }

        }
        driver.manage().window().maximize();
        return driver;
    }

    @AfterClass
    public void closeBrowserInstance() {
        if (driver != null) {
            driver.quit();
        }
    }



}
