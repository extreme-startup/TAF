package automation.examples.storefront.business;

import automation.examples.site.pages.landing.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class LandingPageDefinitionsSteps {

    @Autowired
    private LandingPage landingPage;

    @Given("^User has navigated to Landing Page$")
    public void navigateToLandingPage() {
        landingPage.openPage();
    }

}
