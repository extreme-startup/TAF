package automation.examples.api.resources;

import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Service
public class ContestQuestions {


    private static final String ENDPOINT = "/contest/{id}/questions";

    public Response get(final Integer contestID) {
        return given().spec(requestSpecification).pathParam("id", contestID).get(ENDPOINT);
    }

}
