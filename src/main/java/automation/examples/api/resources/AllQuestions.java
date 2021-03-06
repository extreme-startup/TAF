package automation.examples.api.resources;

import automation.examples.api.model.request.QuestionDTO;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Service
public class AllQuestions {

    private static final String ENDPOINT = "/questions";

    public Response get() {
        return given().spec(requestSpecification).get(ENDPOINT);
    }

    public Response post(final QuestionDTO question) {
        return given().spec(requestSpecification).body(question).post(ENDPOINT);
    }

}
