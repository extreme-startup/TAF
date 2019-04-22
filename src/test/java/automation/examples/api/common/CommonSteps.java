package automation.examples.api.common;

import automation.examples.framework.spring.AppConfig;
import automation.examples.framework.spring.CustomerHelper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import static automation.examples.api.RestAssuredContext.request;
import static automation.examples.framework.spring.CustomerHelper.userLogin;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.http.ContentType.JSON;
import static java.lang.Boolean.valueOf;

@Component
@ContextConfiguration(classes = AppConfig.class)
public class CommonSteps {

    @Value("${api.baseURL}")
    private String baseURL;

    @Value("${api.logger}")
    private String apiLogger;

    @Autowired
    private CustomerHelper customerHelper;

    public void setApiRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setContentType(JSON)
                .setAccept(JSON)
                .setBaseUri(baseURL)
                .build();

        if (valueOf(apiLogger)) {
            request.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }
    }

    public void setUserLogin() {
        userLogin = customerHelper.getRandomRegisteredEmail();
    }

}
