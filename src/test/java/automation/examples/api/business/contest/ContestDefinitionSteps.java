package automation.examples.api.business.contest;

import automation.examples.api.model.request.ContestDTO;
import automation.examples.api.model.response.AllContestDTO;
import automation.examples.api.resources.Contest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static automation.examples.api.RestAssuredContext.response;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class ContestDefinitionSteps {

    private ContestDTO storedContest;

    @Autowired
    private Contest contest;


    @When("^Client calls All Contests service$")
    public void callAllContestsService() {
        response = contest.get();
    }

    @When("^Client (?:calls|has called) Add Contest service$")
    public void callAddContestService() {
        storedContest = ContestDTO.getContestToAdd();
        response = contest.post(storedContest);
    }


    @Then("^All Contests service response has added contest$")
    public void verifyResponseContainsId() {
        callAllContestsService();
        final List<AllContestDTO> contests = Arrays.asList(response.as(AllContestDTO[].class));
        assertThat(contests.stream().map(AllContestDTO::getName).anyMatch(name -> name.equals(storedContest.getName())))
                .withFailMessage(format("Response doesn't contain contest with name: %s",
                        storedContest.getName())).isTrue();
    }

    @Then("^All Contests service response doesn't have added contest$")
    public void verifyResponseDoesntHaveDeletedContest() {
        callAllContestsService();
        final List<AllContestDTO> contests = Arrays.asList(response.as(AllContestDTO[].class));
        final Integer expectedContestId = new ContestByIdDefinitionSteps().getContestId();
        assertThat(contests.stream().map(AllContestDTO::getId)
                .noneMatch(id -> id.equals(expectedContestId)))
                .withFailMessage(format("Response contains contest with id:%d", expectedContestId)).isTrue();
    }

}
