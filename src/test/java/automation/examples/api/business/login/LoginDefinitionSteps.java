package automation.examples.api.business.login;

import automation.examples.api.RestAssuredContext;
import automation.examples.api.model.response.UserDTO;
import automation.examples.api.resources.Login;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static automation.examples.api.RestAssuredContext.response;
import static automation.examples.framework.spring.CustomerHelper.userLogin;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginDefinitionSteps {

    @Autowired
    private Login login;

    @When("^Client (?:calls|has called) Login service$")
    public void callLoginService() {
        RestAssuredContext.response = login.post(userLogin);
        login.setLoginCookie(response);
    }

    @Then("^response contains expected email")
    public void verifyResponseContainsExpectedEmail() {
        assertThat(RestAssuredContext.response.as(UserDTO.class).getEmail()).isEqualToIgnoringCase(userLogin);
    }

    @Then("^Client is able to login$")
    public void verifyCustomerIsAbleToLogin() {
        callLoginService();
        verifyResponseContainsExpectedEmail();
    }

}
