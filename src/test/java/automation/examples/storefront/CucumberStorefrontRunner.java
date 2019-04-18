package automation.examples.storefront;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "automation.examples.storefront.business",
        features = "src/test/resources/features/storefront",
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json"}
)
public class CucumberStorefrontRunner {
}
