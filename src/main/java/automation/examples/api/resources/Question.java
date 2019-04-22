package automation.examples.api.resources;

import automation.examples.api.model.request.QuestionDTO;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Service
public class Question {

    private static final String ENDPOINT = "/questions/{id}";

    public Response get(final String questionId) {
        return given().spec(requestSpecification).pathParam("id", questionId).get(ENDPOINT);
    }

    public Response put(final QuestionDTO questionDTO) {
        return given().spec(requestSpecification).body(questionDTO).pathParam("id", questionDTO.getId()).put(ENDPOINT);
    }

    public Response delete(final String questionId) {
        return given().spec(requestSpecification).pathParam("id", questionId).delete(ENDPOINT);
    }

}
