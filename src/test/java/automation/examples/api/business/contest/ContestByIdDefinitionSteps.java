package automation.examples.api.business.contest;

import automation.examples.api.model.request.ContestDTO;
import automation.examples.api.model.response.AllContestDTO;
import automation.examples.api.resources.Contest;
import automation.examples.api.resources.ContestID;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import static automation.examples.api.RestAssuredContext.response;

public class ContestByIdDefinitionSteps {

    private Integer contestId;
    private ContestDTO contestToAdd;

    @Autowired
    private ContestID contestIDresource;

    @Autowired
    private Contest contest;

    @When("^Client calls get Contest by ID service$")
    public void callGetContestByIdService() {
        contestId = contest.getRandomContestId();
        response = contestIDresource.get(contestId);
    }

    @When("^Client calls update Contest by ID service$")
    public void callCUpdateContestByIdService() {
        storeContestInfo();
        response = contestIDresource.put(contestId, contestToAdd);
    }

    @When("^Client calls delete Contest by ID service$")
    public void callDeleteContestByIdService() {
        contestId = contest.getAddedContestId();
        response = contestIDresource.delete(contestId);
    }

    @Then("^response contains added contest$")
    public void verifyResponseContainsAddedContest() {
        final AllContestDTO allContestDTO = response.as(AllContestDTO.class);
        Assertions.assertThat(allContestDTO.getId()).isEqualTo(contestId);
    }

    @Then("^response contains updated contest$")
    public void verifyResponseContainsUpdatedContest() {
        final AllContestDTO allContestDTO = response.as(AllContestDTO.class);
        Assertions.assertThat(allContestDTO).isEqualTo(contestToAdd);
    }

    private void storeContestInfo() {
        contestId = contest.getRandomContestId();
        contestToAdd = ContestDTO.getContestToAdd();
    }

    public Integer getContestId() {
        return contestId;
    }

}
