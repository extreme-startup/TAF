package automation.examples.business;


import automation.examples.framework.spring.AppConfig;
import com.codeborne.selenide.Configuration;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfig.class)
public class Hooks {

    @Value("${webdriver.baseURL}")
    private String baseURL;

    @Value("${webdriver.timeout}")
    private long timeout;

    @Autowired
    private Environment env;

    @Before(order = 0)
    public void setupBrowser() {
        Configuration.browser = env.getProperty("webdriver.browser");
    }

    @Before(order = 0)
    public void setupTimeout() {
        Configuration.pollingInterval = Long.parseLong(env.getProperty("webdriver.pollingInterval"));
        Configuration.timeout = timeout;
    }

    @Before(order = 1)
    public void setupBaseURL() {
        Configuration.baseUrl = baseURL;
    }

    @Before()
    public void maximizeBrowser() {
        Configuration.startMaximized = true;
    }

}
