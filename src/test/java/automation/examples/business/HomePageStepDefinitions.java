package automation.examples.business;

import automation.examples.site.pages.home.HomePage;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageStepDefinitions {

    @Autowired
    private HomePage homePage;

    @Given("^Customer opens Home page$")
    public void customerOpensHomePage() {
        homePage.openPage();
    }

    @When("^Guest navigates to Home Page via Home Page Button$")
    public void navigatesViaHomePageButton() {
        homePage.navigateViaLogoLink();
    }

    @Then("^browser is redirected to Home Page$")
    public void browserOnPage() {
        String expected = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertThat(expected.contains("Homepage")).isTrue();
    }

}
