package automation.examples.api.resources;

import automation.examples.api.model.request.ContestDTO;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Service
public class ContestID {

    private static final String ENDPOINT = "/contest/{id}";

    public Response get(final Integer contestID) {
        return given().spec(requestSpecification).pathParam("id", contestID).get(ENDPOINT);
    }

    public Response put(final Integer contestID, final ContestDTO contestDTO) {
        return given().spec(requestSpecification).pathParam("id", contestID)
                .body(contestDTO).put(ENDPOINT);
    }

    public Response delete(final Integer contestID) {
        return given().spec(requestSpecification).pathParam("id", contestID).delete(ENDPOINT);
    }

}
