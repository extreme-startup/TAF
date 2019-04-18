package automation.examples.api.business.login;

import automation.examples.api.RestAssuredContext;
import automation.examples.api.resources.Register;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterDefinitionSteps {

    @Autowired
    private Register register;

    @When("^Client calls Register service$")
    public void callRegisterService() {
        RestAssuredContext.response = register.post();
    }

}
