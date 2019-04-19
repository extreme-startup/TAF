package automation.examples.api.resources;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import static automation.examples.api.RestAssuredContext.request;

@Component
public class Logout {

    private static final String ENDPOINT = "/auth/logout/";

    public Response get() {
        return request.get(ENDPOINT);
    }

}
