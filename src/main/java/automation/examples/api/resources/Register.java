package automation.examples.api.resources;

import automation.examples.api.model.request.LoginDTO;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static automation.examples.framework.spring.CustomerHelper.getNewEmail;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Service
public class Register {

    private static final String ENDPOINT = "/auth/register";

    public Response post() {
        return given().spec(requestSpecification).body(new LoginDTO(getNewEmail())).post(ENDPOINT);
    }

}
