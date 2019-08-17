package pages;

import config.BaseClass;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BaseClass{

    public LandingPage() {
        driver = getDriver();
        getConfigPoperties();
        getObjectRepoFile();

    }


    public void checkMandatoryElements(){
       // driver.findElement(By.xpath(objectProperties.getProperty("stocknofieldXpath"))).isDisplayed();
        driver.findElement(By.xpath(testDataProperties.getProperty("applogo"))).isDisplayed();
        driver.findElement(By.xpath(testDataProperties.getProperty("searchBox"))).isDisplayed();
        driver.findElement(By.xpath(testDataProperties.getProperty("checkBox"))).isDisplayed();
    }

    public void checkMandatoryFieldsForRegistrationPage(){

        driver.findElement(By.xpath(testDataProperties.getProperty("usernameLableXpath"))).isDisplayed();
        driver.findElement(By.xpath(testDataProperties.getProperty("passwordLableXpath"))).isDisplayed();
        driver.findElement(By.xpath(testDataProperties.getProperty("renamePasswordXpath"))).isDisplayed();
        driver.findElement(By.xpath(testDataProperties.getProperty("titleXpath"))).isDisplayed();
        driver.findElement(By.xpath(testDataProperties.getProperty("firstNameLableXpath"))).isDisplayed();

    }


    public Boolean checkRegistrationPageTitle(){
        driver.findElement(By.xpath(testDataProperties.getProperty("registerHeading"))).isDisplayed();
        return true;
    }

    public Registration clickRegisterLink(){
        driver.findElement(By.xpath(testDataProperties.getProperty("registrationLink"))).click();
        return new Registration(driver);
    }

    public void navigateToStartingPage(){
       LandingPage.navigateToLandingPage();
    }





}
