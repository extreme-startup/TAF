package automation.examples.api.resources;

import automation.examples.api.model.request.LoginDTO;
import automation.examples.framework.spring.EmailConfigurator;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static automation.examples.api.RestAssuredContext.request;

@Service
public class Register {

    @Autowired
    private EmailConfigurator emailConfigurator;

    private static final String REGISTER_PATH = "/auth/register";

    public Response post() {
        return request.body(new LoginDTO(emailConfigurator.getEmail())).post(REGISTER_PATH);
    }

}
