package automation.examples.api.business.questions;

import automation.examples.api.model.request.QuestionDTO;
import automation.examples.api.resources.RandomQuestion;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static automation.examples.api.RestAssuredContext.response;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomQuestionDefinitionSteps {

    @Autowired
    private RandomQuestion randomQuestion;

    @When("^Client call Get Random Question service$")
    public void callAllQuestionsService() {
        response = randomQuestion.get();
    }

    @Then("^response contains question$")
    public void verifyResponseContainsAddedQuestion() {
        assertThat(response.as(QuestionDTO.class).getId()).isNotEmpty();
    }

}
