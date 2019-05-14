package automation.examples.api.business.login;

import automation.examples.api.model.response.UserAuthenticatedDTO;
import automation.examples.api.resources.GetUserAuthenicated;
import automation.examples.framework.spring.CustomerHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import static automation.examples.api.RestAssuredContext.response;

public class GetUserAuthenticatedDefinitionSteps {

    @Autowired
    private GetUserAuthenicated getUserAuthenicated;

    @Autowired
    private CustomerHelper customerHelper;

    @When("^Client calls Get User Authenticated service$")
    public void callGetUserAuthenticatedService() {
        response = getUserAuthenicated.get();
    }

    @Then("user is authenticated")
    public void verifyUserIsAuthenticated() {
        UserAuthenticatedDTO userAuthenticatedDTO = response.as(UserAuthenticatedDTO.class);
        Assertions.assertThat(userAuthenticatedDTO.getUser()).isNotEmpty();
    }

}
