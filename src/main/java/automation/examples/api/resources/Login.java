package automation.examples.api.resources;

import automation.examples.api.model.requestform.LoginForm;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static automation.examples.api.RestAssuredContext.request;

@Service
public class Login {

    private static final String LOGIN_PATH = "/auth/login/";

    public Response post(final String userLogin) {
        return request.body(new LoginForm(userLogin))
                .post(LOGIN_PATH);
    }

}
