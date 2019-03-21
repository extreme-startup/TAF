package automation.examples.business;

import automation.examples.site.pages.landing.LandingPage;
import automation.examples.storage.Storage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class LandingPageDefinitionsSteps {

    @Autowired
    private LandingPage landingPage;

    @Autowired
    private Storage storage;

    @Given("^User has navigated to Landing Page$")
    public void navigateToLandingPage() {
        landingPage.openPage();
    }

    @Given("^logged in User$")
    public void navigateToLandingPageAndLogin() {
        landingPage.openPage();
        landingPage.getLoginFragment().login(storage.getCredentials());
    }

    @When("^User logs in$")
    public void login() {
        landingPage.getLoginFragment().login(storage.getCredentials());
    }

    @Then("^they are logged in$")
    public void verifyUserIsLoggedIn() {
        assertThat(landingPage.isProfileLinkEnabled()).withFailMessage("User is not logged in").isTrue();
    }

}