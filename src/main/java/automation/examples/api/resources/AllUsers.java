package automation.examples.api.resources;

import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Service
public class AllUsers {

    private static final String ENDPOINT = "/users";

    public Response get() {
        return given().spec(requestSpecification).get(ENDPOINT);
    }

}
