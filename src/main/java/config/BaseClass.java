package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseClass extends Driver {

    /**
     * Method used to navigate to landing page, this will use environment variable
     * to load in appropriate environment.
     */
    public static void navigateToLandingPage() {

        String environmentToLoad = System.getProperty("environment", "local");

        switch (environmentToLoad.charAt(0)) {
            case 'l':
                driver.manage().deleteAllCookies();
                driver.navigate().to(objectProperties.getProperty(("localEnvironmentBaseUrl")));

                break;
            case 'd':
                //for Dev envrionment
                break;
            case 'q':
                //for QA environment
                break;
        }

    }




    /**
     * Object Repository properties file to handle the application configuration and elements of application
     */

    public static FileInputStream fis = null;
    public static Properties objectProperties = new Properties();
    public static Properties testDataProperties = new Properties();

    public static void getConfigPoperties(){

        try{
            fis = new FileInputStream(System.getProperty("user.dir")+"//src//objectrepository//config.properties");
            objectProperties.load(fis);
        }catch (FileNotFoundException fne){

            System.out.println(fne.getMessage());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Function to load the test data file.
     */
    public static void getObjectRepoFile(){

        try{
            fis = new FileInputStream(System.getProperty("user.dir")+"//src//objectrepository//objectRepo.properties");
            testDataProperties.load(fis);
        }catch (FileNotFoundException fne){

            System.out.println(fne.getMessage());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * A static function used to find the elements in different ways
     * @param by
     * @return element
     */
    public static WebElement findElement(By by){
        WebElement element = driver.findElement(by);
        return element;
    }

    /**
     * A static function used to find whether the element is present or not in the web page
     */
    public static boolean isElementVisible(String className) {
        try {
            driver.findElement(By.className(className)).isDisplayed();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Reusable function to click the link, by providing the link name
     * @param linkname
     */
    public static void clickLink(String linkname){

        driver.findElement(By.linkText(linkname)).click();
    }

}
