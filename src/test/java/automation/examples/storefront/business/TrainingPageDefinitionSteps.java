package automation.examples.storefront.business;

import automation.examples.site.pages.session.SessionPage;
import automation.examples.site.pages.training.TrainingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class TrainingPageDefinitionSteps extends CucumberDefinitionSteps {

    private String question;
    private String answer = "Simple answer";
    private String value = "1";
    private String answerSuffix = " after editing";
    private String valueSuffix = "2";

    @Autowired
    private TrainingPage trainingPage;

    @Autowired
    private SessionPage sessionPage;

    @Given("^has provided static question$")
    public void provideStaticQuestion() {
        question = String.format("Simple question %s", getTimestamp());

        trainingPage.openNewQuestionFragment();
        trainingPage.getQuestionFragment().provideRequiredDetailsForQuestion(question, answer, value);
    }

    @Given("^has added question$")
    public void addedQuestion() {
        question = String.format("Simple question %s", getTimestamp());

        trainingPage.openNewQuestionFragment();
        trainingPage.getQuestionFragment().provideRequiredDetailsForQuestion(question, answer, value);
        trainingPage.getQuestionFragment().saveQuestion();
        trainingPage.waitUntilQuestionShouldBeAppear(question);
    }

    @Given("^(?:User |)(?:adds|has added) new session$")
    public void addNewSession() {
        trainingPage.switchToSessionTab();
        trainingPage.getSessionTabFragment().addNewSession();
        sessionPage.waitForSessionIsCreated();
    }

    @When("^User tries add question with empty fileds$")
    public void addEmptyQuestion() {
        trainingPage.openNewQuestionFragment();
        trainingPage.getQuestionFragment().saveQuestion();
    }

    @When("^User saves question$")
    public void saveQuestion() {
        trainingPage.getQuestionFragment().saveQuestion();
        trainingPage.waitUntilQuestionShouldBeAppear(question);
    }

    @When("^User cancel question creation$")
    public void cancelQuestion() {
        trainingPage.getQuestionFragment().cancelQuestion();
    }

    @When("^User cancels deletion of previously added question$")
    public void cancelDeletePreviousQuestion() {
        trainingPage.deleteQuestion(question);
        trainingPage.getDeleteQuestionFragment().cancelDeletion();
    }

    @When("^User deletes previously added question$")
    public void deletePreviousQuestion() {
        trainingPage.deleteQuestion(question);
        trainingPage.getDeleteQuestionFragment().confirmDeletion();
        trainingPage.waitUntilQuestionShouldBeDisappear(question);
    }

    @When("^User editing previously added question$")
    public void editPreviousQuestion() {
        trainingPage.editQuestion(question);
        trainingPage.getQuestionFragment().provideAnswerWithValue(answerSuffix, valueSuffix);
        trainingPage.getQuestionFragment().saveQuestion();
        trainingPage.refreshPage();

        answer = answer + answerSuffix;
        value = value + valueSuffix;
    }

    @When("^User canceling edition previously added question$")
    public void cancelEditPreviousQuestion() {
        trainingPage.editQuestion(question);
        trainingPage.getQuestionFragment().provideAnswerWithValue(answerSuffix, valueSuffix);
        trainingPage.getQuestionFragment().cancelQuestion();
    }

    @Then("^question is saved according to the changes$")
    public void verifyQuestionIsSaved() {
        trainingPage.editQuestion(question);

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(trainingPage.getQuestionFragment().getAnswer()).isEqualTo(answer);
            softAssertions.assertThat(trainingPage.getQuestionFragment().getValue()).isEqualTo(value);

        });
    }

    @Then("^added question is displayed on Training Page$")
    public void verifyAddedQuestionIsDisplayed() {
        assertThat(trainingPage.isAddedQuestionDisplayed(question))
                .withFailMessage("Added question is missing").isTrue();
    }

    @Then("^question is not present on Training Page$")
    public void verifyQuestionIsNotPresent() {
        assertThat(trainingPage.isAddedQuestionExist(question))
                .withFailMessage("Added question is present").isFalse();
    }

    @Then("^validation error messages for add question mandatory fields are displayed$")
    public void verifyAddQuestionErrorMessagesAreDisplayed() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(trainingPage.getQuestionFragment().isQuestionErrorMessageDisplayed())
                    .withFailMessage("Add question error message is not displayed").isTrue();
            softAssertions.assertThat(trainingPage.getQuestionFragment().isAnswerErrorMessageDisplayed())
                    .withFailMessage("Add answer error messages is not displayed").isTrue();
            softAssertions.assertThat(trainingPage.getQuestionFragment().isValueErrorMessageDisplayed())
                    .withFailMessage("Add question value error messages is not displayed").isTrue();
        });
    }

    @Then("^add question mandatory fields are highlighted$")
    public void verifyAddQuestionFieldsAreHighlighted() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(trainingPage.getQuestionFragment().isQuestionHighlighted())
                    .withFailMessage("Question field is not highlighted").isTrue();
            softAssertions.assertThat(trainingPage.getQuestionFragment().isAnswerHighlighted())
                    .withFailMessage("Answer field is not highlighted").isTrue();
            softAssertions.assertThat(trainingPage.getQuestionFragment().isValueHighlighted())
                    .withFailMessage("Question value field is not highlighted").isTrue();
        });
    }

}
