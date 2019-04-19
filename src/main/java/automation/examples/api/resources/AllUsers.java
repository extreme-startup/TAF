package automation.examples.api.resources;

import automation.examples.api.RestAssuredContext;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

@Service
public class AllUsers {

    private static final String ENDPOINT = "/users";

    public Response get() {
        return RestAssuredContext.request.get(ENDPOINT);
    }

}
