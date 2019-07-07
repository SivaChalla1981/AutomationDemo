package pages;

import config.BaseClass;
import org.openqa.selenium.WebDriver;

public class Registration extends BaseClass {


    public Registration(){

        driver = getDriver();
        getConfigPoperties();
        getObjectRepoFile();
    }

    public Registration(WebDriver driver) {

    }

    public CompleteRegistraion doregistration(){



      return  new CompleteRegistraion(driver);
  }



}
