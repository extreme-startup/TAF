package automation.examples.storefront.business;

import automation.examples.site.components.trainings.TrainingFragment;
import automation.examples.site.pages.home.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static automation.examples.framework.spring.CustomerHelper.userLogin;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class HomePageStepDefinitions extends CucumberDefinitionSteps {

    private String trainingName;
    private String trainingDescription;
    private List<TrainingFragment> trainingsAmount;

    @Autowired
    private HomePage homePage;

    @Given("^User has opened '([\\w\\s]+)' training")
    public void openCompetition(final String trainingName) {
        homePage.getTrainingSectionFragment().waitForTrainingToAppear(trainingName);
        homePage.getTrainingSectionFragment().clickOnTrainingName(trainingName);
    }

    @Given("^User has navigated to Home Page$")
    public void navigateToHomePage() {
        homePage.openPage();
    }

    @Given("^logged in User$")
    public void navigateToLandingPageAndLogin() {
        homePage.openPage();
        homePage.getLoginFragment().login(userLogin);
    }

    @Given("^User (?:adds|has added) new training$")
    public void addNewTraining() {
        trainingName = String.format("Simple training %s", getTimestamp());
        trainingDescription = String.format("Training description %s", getTimestamp());

        clickOnAddNewTraining();
        homePage.getAddNewTrainingPopUp().provideDetailsForTrainingCreation(trainingName, trainingDescription);
        homePage.getAddNewTrainingPopUp().saveTrainingCreation();
        homePage.getTrainingSectionFragment().waitForTrainingToAppear(trainingName);
    }

    @When("^User clicks on Add to Training$")
    public void clickOnAddNewTraining() {
        homePage.getTrainingSectionFragment().clickAddNewTrainingButton();
    }

    @When("^User deletes the training$")
    public void deleteTraining() {
        trainingsAmount = homePage.getTrainingSectionFragment().getTrainings();
        homePage.getTrainingSectionFragment().deleteTrainingByName(trainingName);
        homePage.getConfirmDeletionPopUp().confirmDeletion();
        homePage.getTrainingSectionFragment().waitForTrainingToDisappear(trainingName);
    }

    @When("^User cancels deletion of the training$")
    public void cancelTrainingDeletion() {
        homePage.getTrainingSectionFragment().deleteTrainingByName(trainingName);
        homePage.getConfirmDeletionPopUp().cancelDeletion();
    }

    @When("^User edits the training$")
    public void editTraining() {
        trainingName = String.format("Updated training %s", getTimestamp());
        homePage.getTrainingSectionFragment().editTrainingByName(trainingName);
    }

    @When("^User logs in$")
    public void login() {
        homePage.getLoginFragment().login(userLogin);
    }


    @When("^User cancels training creation$")
    public void cancelTrainingCreation() {
        homePage.getAddNewTrainingPopUp().cancelTrainingCreation();
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
            softAssertions.assertThat(homePage.getProfileEmail()).isEqualTo(userLogin);
            softAssertions.assertThat(homePage.isProfileLinkEnabled())
                    .withFailMessage("User is not logged in").isTrue();
        });
    }

    @Then("^(?:added|updated) training is displayed on Home Page in the Training section$")
    public void verifyAddedTrainingIsDisplayed() {
        assertThat(homePage.getTrainingSectionFragment().isAddedTrainingDisplayed(trainingName, trainingDescription))
                .withFailMessage("Added or Updated training is missing " + trainingName).isTrue();
    }

    @Then("^add new training pop up is not displayed on Home Page$")
    public void verifyAddNewTrainingPopUpIsNotDisplayed() {
        assertThat(homePage.isAddNewTrainingPopUpDisplayed())
                .withFailMessage("Add new training pop up is displayed").isFalse();
    }

    @Then("^save button is disabled$")
    public void verifySaveButtonIsDisabled() {
        assertThat(homePage.getAddNewTrainingPopUp().isSaveButtonEnabled())
                .withFailMessage("Save button is enabled").isFalse();
    }

    @Then("^training is not displayed on Home Page in the Training section$")
    public void verifyAddedTrainingIsNotDisplayed() {
        assertThat(homePage.getTrainingSectionFragment().getTrainings(),
                hasSize(trainingsAmount.size() - 1));
    }

}
