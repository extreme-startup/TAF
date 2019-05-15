package automation.examples.storefront.business;

import automation.examples.site.pages.session.SessionPage;
import automation.examples.site.pages.training.TrainingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class SessionPageDefinitionSteps extends CucumberDefinitionSteps {

    @Autowired
    private SessionPage sessionPage;

    @Autowired
    private TrainingPage trainingPage;

    @Given("^User (?:starts|has started) session$")
    public void startSession() {
        sessionPage.startSession();
        sessionPage.waitForSessionIsStarted();
    }

    @Given("^User (?:pauses|has paused) session$")
    public void pauseSession() {
        sessionPage.pauseSession();
        sessionPage.waitForSessionIsPaused();
    }

    @When("^User resumes session$")
    public void resumeSession() {
        sessionPage.startSession();
        sessionPage.waitForSessionIsStarted();
    }

    @When("^User stops session$")
    public void stopSession() {
        sessionPage.stopSession();
        sessionPage.waitForSessionIsStopped();
    }

    @Then("^session status is ([\\w ]+)$")
    public void verifySessionStatus(final String sessionStatus) {
        assertThat(sessionPage.getSessionStatusValue()).isEqualTo(sessionStatus);
    }

    @Then("^Start Session button is available$")
    public void verifyStartButtonIsAvailable() {
        assertThat(sessionPage.isStartButtonAvailable())
                .withFailMessage("Start Session button is not available").isTrue();
    }

    @Then("^Pause Session button is available$")
    public void verifyPauseButtonIsAvailable() {
        assertThat(sessionPage.isPauseButtonAvailable())
                .withFailMessage("Pause Session button is not available").isTrue();
    }

    @Then("^Stop Session button is available$")
    public void verifyStopButtonIsAvailable() {
        assertThat(sessionPage.isStopButtonAvailable())
                .withFailMessage("Pause Session button is not available").isTrue();
    }

    @Then("^link for training session is displayed$")
    public void verifyLinkIsDisplayed() {
        assertThat(sessionPage.getLinkForTrainingSession()).isNotEmpty();
    }

}
