package api.business;

import api.RestAssuredContext;
import automation.examples.framework.spring.AppConfig;
import cucumber.api.java.Before;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.given;

@ContextConfiguration(classes = AppConfig.class)
public class ApiHooks {

    @Value("${api.baseURL}")
    private String baseURL;

    @Before(order = 0)
    public void setBaseUrl() {
        RestAssuredContext.request = given()
                .baseUri(baseURL)
                .contentType(ContentType.JSON);
    }

}
