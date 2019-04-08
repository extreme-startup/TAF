package automation.examples.api.business;

import automation.examples.framework.spring.AppConfig;
import cucumber.api.java.Before;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import static automation.examples.api.RestAssuredContext.request;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static java.lang.Boolean.valueOf;

@ContextConfiguration(classes = AppConfig.class)
public class ApiHooks {

    @Value("${api.baseURL}")
    private String baseURL;

    @Value("${api.logger}")
    private String apiLogger;

    @Before(order = 0)
    public void setPreconditions() {
        request = given().contentType(JSON)
                .baseUri(baseURL);
        if (valueOf(apiLogger)) {
            request.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }
    }

}
