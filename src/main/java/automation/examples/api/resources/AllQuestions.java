package automation.examples.api.resources;

import automation.examples.api.RestAssuredContext;
import automation.examples.api.model.request.QuestionDTO;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

@Service
public class AllQuestions {

    private static final String ALL_QUESTIONS_PATH = "/questions";

    private final QuestionDTO questionDTO = new QuestionDTO();

    public Response get() {
        return RestAssuredContext.request.get(ALL_QUESTIONS_PATH);
    }

    public Response post() {
        setQuestionDTO();
        return RestAssuredContext.request.body(questionDTO).post(ALL_QUESTIONS_PATH);
    }

    private void setQuestionDTO() {
        questionDTO.setType("static");
        questionDTO.setText("What is the capital of Ukraine?");
        questionDTO.setAnswer("Kyiv");
        questionDTO.setValue("4");
        questionDTO.setContestId("2");
    }

}
