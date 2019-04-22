package automation.examples.api.resources;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Component
public class Logout {

    private static final String ENDPOINT = "/auth/logout/";

    public Response get() {
        return given().spec(requestSpecification).get(ENDPOINT);
    }

}
