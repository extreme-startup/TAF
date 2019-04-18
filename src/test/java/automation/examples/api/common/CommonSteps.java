package automation.examples.api.common;

import automation.examples.framework.spring.AppConfig;
import automation.examples.framework.spring.CustomerHelper;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import static automation.examples.api.RestAssuredContext.request;
import static automation.examples.framework.spring.CustomerHelper.userLogin;
import static io.restassured.RestAssured.given;
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
        request = given().contentType(JSON).accept(JSON).baseUri(baseURL);
        if (valueOf(apiLogger)) {
            request.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }
    }

    public void setUserLogin() {
        userLogin = customerHelper.getRandomRegisteredEmail();
    }

}
