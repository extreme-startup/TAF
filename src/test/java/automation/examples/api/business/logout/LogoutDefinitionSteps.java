package automation.examples.api.business.logout;

import automation.examples.api.resources.Logout;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static automation.examples.api.RestAssuredContext.response;

public class LogoutDefinitionSteps {

    @Autowired
    private Logout logout;


    @When("^Client calls Logout service$")
    public void callLogoutService() {
        response = logout.get();
    }

}
