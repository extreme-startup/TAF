package automation.examples.api.resources;

import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static automation.examples.api.RestAssuredContext.request;

@Service
public class User {

    private static final String ENDPOINT = "/users/{id}";

    public Response get(final String userId) {
        return request.pathParam("id", userId).get(ENDPOINT);
    }

}
