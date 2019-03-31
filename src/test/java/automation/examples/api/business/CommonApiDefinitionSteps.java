package automation.examples.api.business;

import automation.examples.api.RestAssuredContext;
import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;

import java.util.Map;

import static automation.examples.api.RestAssuredContext.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CommonApiDefinitionSteps {

    @Then("^response status code is ([\\d]{3})$")
    public void verifyResponseStatusCode(int statusCode) {
        validatableResponse = response.then().statusCode(statusCode);
    }

    @Then("^response body contains the following$")
    public void verifyResponseContainsFields(Map<String, String> expectedFields) {
        final JsonPath jp = new JsonPath(RestAssuredContext.response.asString());

        assertThat(expectedFields.entrySet().stream().allMatch(entry -> jp.get(entry.getKey())
                .equals(entry.getValue()))).isTrue();
    }



}
