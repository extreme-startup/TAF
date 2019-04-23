package automation.examples.api.business.contest;

import automation.examples.api.resources.Contest;
import automation.examples.api.resources.ContestQuestions;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static automation.examples.api.RestAssuredContext.response;

public class ContestQuestionsDefinitionSteps {

    private Integer contestId;

    @Autowired
    private ContestQuestions contestQuestions;

    @Autowired
    private Contest contest;

    @When("^Client calls get Contest Questions service$")
    public void callContestQuestionsService() {
        contestId = contest.getRandomContestId();
        response = contestQuestions.get(contestId);
    }

}
