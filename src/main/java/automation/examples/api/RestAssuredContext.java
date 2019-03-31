package automation.examples.api;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestAssuredContext {

    public static Response response;
    public static ValidatableResponse validatableResponse;
    public static RequestSpecification request;

}
