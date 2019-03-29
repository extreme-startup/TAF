package automation.examples.business;

import automation.examples.site.pages.landing.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginDefinitionSteps {

    @Autowired
    private LandingPage landingPage;

    @Value("${user.login}")
    private String login;

    @Given("^logged in User$")
    public void navigateToLandingPageAndLogin() {
        landingPage.openPage();
        landingPage.getLoginFragment().login(login);
    }

    @When("^User logs in$")
    public void login() {
        landingPage.getLoginFragment().login(login);
    }

    @When("^User provides invalid email: (.*)$")
    public void loginWithInvalidEmail(final String invalidEmail) {
        landingPage.getLoginFragment().provideEmail(invalidEmail);
    }

    @Then("^they are logged in$")
    public void verifyUserIsLoggedIn() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(landingPage.getProfileEmail()).isEqualTo(login);
            softAssertions.assertThat(landingPage.isProfileLinkEnabled())
                    .withFailMessage("User is not logged in").isTrue();
        });
    }

    @Then("^login error message is displayed$")
    public void verifyLoginErrorMessageIsDisplayed() {
        assertThat(landingPage.getLoginFragment().isLoginErrorMessageDisplayed())
                .withFailMessage("Login error message is missing").isTrue();
    }

    @Then("^login field is highlighted$")
    public void verifyLoginFieldIsHighlighted() {
        assertThat(landingPage.getLoginFragment().isLoginHighlighted())
                .withFailMessage("Login field is not highlighted").isTrue();
    }

}
