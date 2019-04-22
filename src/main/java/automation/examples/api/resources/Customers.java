package automation.examples.api.resources;

import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import static automation.examples.api.RestAssuredContext.request;

@Service
public class Customers {

    private static final String ENDPOINT = "/customers";

    public Response get() {
        return request.get(ENDPOINT);
    }

}
