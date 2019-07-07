package stepdefs;

import static config.Driver.driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LandingPage;

public class registrationstepdefs {

    LandingPage lp = new LandingPage();

    @Given("As a new user i open the RSS component url in browser")
    public void as_a_new_user_i_open_the_RSS_component_url_in_browser() {
        lp.navigateToRegistrationPage();
    }

    @When("application is loaded fully")
    public void application_is_loaded_fully() {

    }

    @Then("I need to see the mandatory attributes")
    public void i_need_to_see_the_mandatory_attributes() {

    }

    @Then("I close my browser instance")
    public void i_close_my_browser_instance(){
        lp.closeBrowserInstance();
    }

}
