package automation.examples.api.resources;

import automation.examples.api.RestAssuredContext;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

@Service
public class AllQuestions {

    private static final String ALL_QUESTIONS_PATH = "/questions";

    public Response get(){
        return RestAssuredContext.request.get(ALL_QUESTIONS_PATH);
    }

}
