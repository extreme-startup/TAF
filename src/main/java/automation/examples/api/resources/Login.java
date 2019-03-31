package automation.examples.api.resources;

import automation.examples.api.crud.Postable;
import automation.examples.api.requestform.LoginForm;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static automation.examples.api.RestAssuredContext.request;

@Service
public class Login implements Postable {

    private static final String LOGIN_PATH = "/auth/login/";

    @Value("${user.login}")
    private String userLogin;

    @Override
    public Response post() {
        return request.body(new LoginForm(userLogin))
                .post(LOGIN_PATH);
    }

}
