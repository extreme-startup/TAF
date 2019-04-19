package automation.examples.api.resources;

import automation.examples.api.model.request.LoginDTO;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Service
public class Login {

    private static final String ENDPOINT = "/auth/login/";

    public Response post(final String userLogin) {
        return given().spec(requestSpecification).body(new LoginDTO(userLogin)).post(ENDPOINT);
    }

}
