package api.business;

import api.RestAssuredContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import org.assertj.core.api.Assertions;

import java.util.Map;

import static api.RestAssuredContext.request;
import static api.RestAssuredContext.response;
import static api.RestAssuredContext.validatableResponse;

public class CommonApiDefinitionSteps {

    @Given("^set query parameter(?:s|)$")
    public void setQueryParams(Map<String, String> queryParams) {
        request.queryParams(queryParams);
    }

    @Given("^set path parameter(?:s|)$")
    public void setPathParams(Map<String, String> pathParams) {
        request.pathParams(pathParams);
    }

    @When("^Client makes ([\\w]+) request for ([\\w/]+) path$")
    public void makeRequest(String requestType, String path) {
        response = request.when().request(requestType, path);
    }

    @Then("^response status code is ([\\d]{3})$")
    public void verifyResponseStatusCode(int statusCode) {
        validatableResponse = response.then().statusCode(statusCode);
    }

    @Then("response body contains the following")
    public void verifyResponseContainsFields(Map<String, String> expectedFields) {
        final JsonPath jp = new JsonPath(RestAssuredContext.response.asString());

        Assertions.assertThat(expectedFields.entrySet().stream().allMatch(entry -> jp.get(entry.getKey())
                .equals(entry.getValue()))).isTrue();
    }

}
