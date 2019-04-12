package automation.examples.storefront.business;

import automation.examples.site.pages.home.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageStepDefinitions extends CucumberDefinitionSteps {

    @Autowired
    private HomePage homePage;

    @Value("${user.login}")
    private String login;

    @Given("^User has opened '([\\w\\s]+)' competition$")
    public void openCompetition(final String name) {
        homePage.clickCompetitionLink(name);
    }

    @Given("^User has navigated to Home Page$")
    public void navigateToHomePage() {
        homePage.openPage();
    }

    @Given("^logged in User$")
    public void navigateToLandingPageAndLogin() {
        homePage.openPage();
        homePage.getLoginFragment().login(login);
    }

    @When("^User logs in$")
    public void login() {
        homePage.getLoginFragment().login(login);
    }

    @When("^User provides invalid email: (.*)$")
    public void loginWithInvalidEmail(final String invalidEmail) {
        homePage.getLoginFragment().provideEmail(invalidEmail);
    }

    @Then("^login error message is displayed$")
    public void verifyLoginErrorMessageIsDisplayed() {
        assertThat(homePage.getLoginFragment().isLoginErrorMessageDisplayed())
                .withFailMessage("Login error message is missing").isTrue();
    }

    @Then("^login field is highlighted$")
    public void verifyLoginFieldIsHighlighted() {
        assertThat(homePage.getLoginFragment().isLoginHighlighted())
                .withFailMessage("Login field is not highlighted").isTrue();
    }

    @Then("^they are logged in$")
    public void verifyUserIsLoggedIn() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(homePage.getProfileEmail()).isEqualTo(login);
            softAssertions.assertThat(homePage.isProfileLinkEnabled())
                    .withFailMessage("User is not logged in").isTrue();
        });
    }

}
