package automation.examples.api.resources;

import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Service
public class User {

    private static final String ENDPOINT = "/users/{id}";

    public Response get(final String userId) {
        return given().spec(requestSpecification).pathParam("id", userId).get(ENDPOINT);
    }

}
