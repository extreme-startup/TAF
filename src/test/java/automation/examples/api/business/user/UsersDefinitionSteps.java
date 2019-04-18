package automation.examples.api.business.user;

import automation.examples.api.RestAssuredContext;
import automation.examples.api.model.response.UserDTO;
import automation.examples.api.resources.AllUsers;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.Arrays.asList;

public class UsersDefinitionSteps {

    @Autowired
    private AllUsers allUsers;

    @When("^Client calls All Users service$")
    public void callAllUsersService() {
        RestAssuredContext.response = allUsers.get();
    }

    @Then("^response contains list of Users$")
    public void verifyResponseContainsUsers() {
        final List<UserDTO> allUsersDTO = asList(RestAssuredContext.response.as(UserDTO[].class));

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(allUsersDTO.stream().noneMatch(it -> it.getEmail().isEmpty()))
                    .withFailMessage("Some emails are undefined").isTrue();
            softly.assertThat(allUsersDTO.stream().noneMatch(it -> it.getId().isEmpty()))
                    .withFailMessage("Some ids are undefined").isTrue();
        });
    }

}
