package automation.examples.api.business.user;

import automation.examples.api.model.response.UserDTO;
import automation.examples.api.resources.User;
import automation.examples.framework.spring.CustomerHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import static automation.examples.api.RestAssuredContext.response;

public class UserDefinitionSteps {

    @Autowired
    private User user;

    @Autowired
    private CustomerHelper customerHelper;

    private String userId;

    @When("^Client calls User service$")
    public void callUsersService() {
        userId = customerHelper.getRandomUserId();
        response = user.get(userId);
    }

    @Then("^response contains expected user$")
    public void verifyResponseContainsExpectedUserId() {
        final String actualUserID = response.as(UserDTO.class).getId();
        Assertions.assertThat(actualUserID).isEqualTo(userId);
    }

}
