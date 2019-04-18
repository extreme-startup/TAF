package automation.examples.storefront.business;

import automation.examples.api.common.CommonSteps;
import automation.examples.framework.spring.AppConfig;
import automation.examples.framework.spring.CustomerHelper;
import com.codeborne.selenide.Configuration;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;

@ContextConfiguration(classes = AppConfig.class)
public class Hooks {

    @Value("${webdriver.baseURL}")
    private String baseURL;

    @Value("${webdriver.timeout}")
    private long timeout;

    @Autowired
    private Environment env;

    @Autowired
    private CustomerHelper customerHelper;

    @Autowired
    private CommonSteps commonSteps;

    @Before(order = 0)
    public void setupBrowser() {
        Configuration.browser = env.getProperty("webdriver.browser");
    }

    @Before(order = 1)
    public void setupTimeout() {
        Configuration.pollingInterval = Long.parseLong(env.getProperty("webdriver.pollingInterval"));
        Configuration.timeout = timeout;
    }

    @Before(order = 1)
    public void clearCookies() {
        clearBrowserCookies();
    }

    @Before(order = 2, value = "@admin")
    public void setUserLogin() {
        commonSteps.setApiRequestSpecification();
        commonSteps.setUserLogin();
    }

    @Before(order = 2)
    public void setupBaseURL() {
        Configuration.baseUrl = baseURL;
    }

    @Before(order = 2)
    public void maximizeBrowser() {
        Configuration.startMaximized = true;
    }

}
