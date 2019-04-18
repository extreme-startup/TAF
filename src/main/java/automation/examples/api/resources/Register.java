package automation.examples.api.resources;

import automation.examples.api.model.request.LoginDTO;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static automation.examples.api.RestAssuredContext.request;
import static automation.examples.framework.spring.CustomerHelper.getNewEmail;

@Service
public class Register {

    private static final String REGISTER_PATH = "/auth/register";

    public Response post() {
        return request.body(new LoginDTO(getNewEmail())).post(REGISTER_PATH);
    }

}
