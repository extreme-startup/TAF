package automation.examples.api.business.questions;

import automation.examples.api.model.request.QuestionDTO;
import automation.examples.api.resources.AllQuestions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

import static automation.examples.api.RestAssuredContext.response;
import static automation.examples.api.model.request.QuestionDTO.getQuestionToAdd;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AllQuestionsDefinitionSteps {

    @Autowired
    private AllQuestions allQuestions;

    private QuestionDTO stored_question;

    @When("^Client calls All Questions service$")
    public void callAllQuestionsService() {
        response = allQuestions.get();
    }

    @When("^Client call Add Question service$")
    public void callAddQuestionService() {
        stored_question = getQuestionToAdd();
        response = allQuestions.post(stored_question);
    }

    @Then("^response contains questions with ids$")
    public void verifyQuestionListIsNotEmpty() {
        final List<QuestionDTO> allQuestionsDTO = asList(response.as(QuestionDTO[].class));
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(allQuestionsDTO).isNotEmpty();
            softly.assertThat(allQuestionsDTO.stream().noneMatch(it -> it.getId().isEmpty()))
                    .withFailMessage("At least one question doesn't have id").isTrue();
        });
    }

    @Then("^question is added to the list$")
    public void verifyQuestionIsAdded() {
        final List<QuestionDTO> questions = asList(allQuestions.get().as(QuestionDTO[].class));
        final QuestionDTO addedQuestion = questions.stream()
                .filter(question -> question.getText().equals(stored_question.getText())).findFirst().orElseThrow(() ->
                        new NoSuchElementException(
                                format("No question was found with text %s", stored_question.getText())));
        assertThat(addedQuestion).isEqualToIgnoringGivenFields(stored_question, "id");
    }

}
