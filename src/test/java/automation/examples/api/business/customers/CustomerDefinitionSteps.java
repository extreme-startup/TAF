package automation.examples.api.business.customers;

import automation.examples.api.model.response.CustomerDTO;
import automation.examples.api.resources.Customers;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static automation.examples.api.RestAssuredContext.response;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerDefinitionSteps {

    @Autowired
    private Customers customers;

    private static final String REGISTERED_CUSTOMER = "john.doe@mysqltutorial.org";

    @When("^Client calls Customers service$")
    public void callCustomerService() {
        response = customers.get();
    }

    @Then("^response contains expected Customer$")
    public void verifyResponseContainsCustomerEmail() {
        final List<CustomerDTO> customers = Arrays.asList(response.as(CustomerDTO[].class));
        assertThat(customers.stream().map(CustomerDTO::getEmail).anyMatch(email -> email.equals(REGISTERED_CUSTOMER)))
                .withFailMessage(format("Response doesn't contain registered customer with email: %s",
                        REGISTERED_CUSTOMER)).isTrue();
    }

}
