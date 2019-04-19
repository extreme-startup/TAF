package automation.examples.api.business.questions;

import automation.examples.api.model.request.QuestionDTO;
import automation.examples.api.resources.AllQuestions;
import automation.examples.api.resources.Question;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

import static automation.examples.api.RestAssuredContext.response;
import static automation.examples.api.model.request.QuestionDTO.getQuestionToUpdate;
import static automation.examples.framework.spring.utils.RandomUtils.getRandomFromCollection;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class QuestionDefinitionSteps {

    @Autowired
    private Question question;

    @Autowired
    private AllQuestions allQuestions;

    private QuestionDTO STORED_QUESTION;

    @When("^Client call Get Question service$")
    public void getQuestionById() {
        final QuestionDTO randomQuestion = getRandomQuestionDTO();
        response = question.get(randomQuestion.getId());
        STORED_QUESTION = randomQuestion;
    }

    @When("^Client call Update Question service$")
    public void updateQuestion() {
        final QuestionDTO randomQuestion = getRandomQuestionDTO();
        STORED_QUESTION = getQuestionToUpdate(randomQuestion.getId());
        response = question.put(STORED_QUESTION);
    }

    @When("^Client call Delete Question service$")
    public void deleteQuestion() {
        STORED_QUESTION = getRandomQuestionDTO();
        response = question.delete(STORED_QUESTION.getId());
    }

    @Then("^response contains requested question$")
    public void verifyResponseContainsRequestedQuestion() {
        assertThat(response.as(QuestionDTO.class)).isEqualTo(STORED_QUESTION);
    }

    @Then("^question is updated$")
    public void verifyQuestionIsUpdate() {
        final QuestionDTO updatedQuestion = getQuestionById(STORED_QUESTION.getId());
        assertThat(updatedQuestion).isEqualToIgnoringGivenFields(STORED_QUESTION, "id");
    }

    @Then("^question is deleted$")
    public void verifyQuestionIsDeleted() {
        assertThat(asList(allQuestions.get().as(QuestionDTO[].class))).doesNotContain(STORED_QUESTION);
    }

    private QuestionDTO getRandomQuestionDTO() {
        final List<QuestionDTO> questions = asList(allQuestions.get().as(QuestionDTO[].class));
        return getRandomFromCollection(questions);
    }

    private QuestionDTO getQuestionById(final String questionId) {
        final List<QuestionDTO> questions = asList(allQuestions.get().as(QuestionDTO[].class));
        return questions.stream()
                .filter(question -> question.getId().equals(questionId)).findFirst().orElseThrow(() ->
                        new NoSuchElementException(format("No question was found with id %s", questionId)));
    }

}
