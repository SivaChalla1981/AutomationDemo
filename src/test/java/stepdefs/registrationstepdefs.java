package stepdefs;

import static config.Driver.driver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.LandingPage;

public class registrationstepdefs {

    LandingPage lp = new LandingPage();

    @Given("As a new user i open the RSS component url in browser")
    public void as_a_new_user_i_open_the_RSS_component_url_in_browser() {
        lp.navigateToStartingPage();
    }

    @When("application is loaded fully")
    public void application_is_loaded_fully() {

    }

    @Then("I need to see the mandatory attributes")
    public void i_need_to_see_the_mandatory_attributes() {
      lp.checkMandatoryElements();
    }

    @Then("I close my browser instance")
    public void i_close_my_browser_instance(){
        lp.closeBrowserInstance();
    }

    @When("^I click the register link$")
    public void i_click_the_register_link() throws Throwable {
       lp.clickRegisterLink();
    }

    @Then("^I'm in registration page$")
    public void i_m_in_registration_page() throws Throwable {
        String url = "https://uk.rs-online.com/web/register/registration";
        Assert.assertEquals(driver.getCurrentUrl(),url);
        Assert.assertTrue(lp.checkRegistrationPageTitle());
    }

    @And("^I click on Registerlink$")
    public void i_click_on_registerlink() throws Throwable {
        lp.clickRegisterLink();
    }

    @Then("^I should see all the mandatory attributes of registration page$")
    public void i_should_see_all_the_mandatory_attributes_of_registration_page() throws Throwable {
        Assert.assertTrue(lp.checkRegistrationPageTitle());
        lp.checkMandatoryFieldsForRegistrationPage();

    }

}
