package automation.examples.api.business;

import cucumber.api.java.en.Then;

import static automation.examples.api.RestAssuredContext.response;

public class CommonApiDefinitionSteps {

    @Then("^response status code is ([\\d]{3})$")
    public void verifyResponseStatusCode(final int statusCode) {
        response.then().statusCode(statusCode);
    }

}
