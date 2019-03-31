package automation.examples.api.business.login;

import automation.examples.api.business.CommonApiDefinitionSteps;
import automation.examples.api.RestAssuredContext;
import automation.examples.api.resources.Login;
import automation.examples.api.resources.User;
import automation.examples.api.responsedto.UserDTO;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginDefinitionSteps {

    //check Object types (Interface/realization)
    @Autowired
    private Login login;

    @Value("${user.login}")
    private String userLogin;

    @When("^Client calls Login service$")
    public void callLoginService() {
        RestAssuredContext.response = login.post();
    }

    @Then("^response contains expected email")
    public void verifyResponseContainsExpectedEmail() {
        assertThat(RestAssuredContext.response.as(UserDTO.class).getEmail()).isEqualToIgnoringCase(userLogin);
    }

}
