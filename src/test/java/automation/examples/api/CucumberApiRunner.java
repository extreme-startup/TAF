package automation.examples.api;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "automation.examples.api.business",
        features = "src/test/resources/features/api",
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json"}
)
public class CucumberApiRunner {
}
