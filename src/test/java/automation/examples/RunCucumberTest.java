package automation.examples;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "automation.examples.business",
        features = "src/test/resources/features",
        plugin = {"pretty","json:target/cucumber-report/cucumber.json","html:target/cucumber-report"}
)
public class RunCucumberTest {
}
