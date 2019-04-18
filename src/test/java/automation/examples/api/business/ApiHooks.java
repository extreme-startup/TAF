package automation.examples.api.business;

import automation.examples.api.common.CommonSteps;
import automation.examples.framework.spring.AppConfig;
import automation.examples.framework.spring.CustomerHelper;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfig.class)
public class ApiHooks {

    @Value("${api.baseURL}")
    private String baseURL;

    @Value("${api.logger}")
    private String apiLogger;

    @Autowired
    private CustomerHelper customerHelper;

    @Autowired
    private CommonSteps commonSteps;

    @Before(order = 0)
    public void setPreconditions() {
        commonSteps.setApiRequestSpecification();
    }

    @Before(order = 1, value = "@admin")
    public void setUserLogin() {
        commonSteps.setUserLogin();
    }

}
