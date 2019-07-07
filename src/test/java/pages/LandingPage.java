package pages;

import config.BaseClass;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BaseClass{

    public LandingPage(){
        getConfigPoperties();
        getObjectRepoFile();
    }

    public LandingPage(WebDriver driver){

        driver = this.driver;

    }

    public Registration navigateToRegistrationPage(){

       LandingPage.navigateToLandingPage();

       return new Registration(driver);
    }



}
