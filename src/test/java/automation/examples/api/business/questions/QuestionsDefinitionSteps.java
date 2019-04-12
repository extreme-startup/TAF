package automation.examples.api.business.questions;

import automation.examples.api.RestAssuredContext;
import automation.examples.api.model.request.QuestionDTO;
import automation.examples.api.resources.AllQuestions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class QuestionsDefinitionSteps {

    @Autowired
    private AllQuestions allQuestions;

    @When("^Client calls All Questions service$")
    public void callAllQuestionsService() {
        RestAssuredContext.response = allQuestions.get();
    }

    @And("^response contains questions with ids$")
    public void verifyQuestionListIsNotEmpty() {
        final List<QuestionDTO> allQuestionsDTO = Arrays.asList(RestAssuredContext.response.as(QuestionDTO[].class));
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(allQuestionsDTO).isNotEmpty();
            softly.assertThat(allQuestionsDTO.stream().noneMatch(it -> it.getId().isEmpty()))
                    .withFailMessage("At least one question doesn't have id").isTrue();
        });
    }

}
