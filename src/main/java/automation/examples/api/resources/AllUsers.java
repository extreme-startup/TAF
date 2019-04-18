package automation.examples.api.resources;

import automation.examples.api.RestAssuredContext;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

@Service
public class AllUsers {

    private static final String ALL_USERS_PATH = "/users";

    public Response get() {
        return RestAssuredContext.request.get(ALL_USERS_PATH);
    }

}
