package automation.examples.business;

import automation.examples.site.pages.home.StoreFinderPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class StoreFinderPageStepDefinition {

    @Autowired
    private StoreFinderPage storeFinderPage;

    @Given("^Guest is on Store Finder Page$")
    public void storeFinderPageIsOpen() {
        storeFinderPage.openPage();
    }


    @When("^fill some fragment: (\\w+)$")
    public void fillSomeFragment(final String postalCode) {
        storeFinderPage.getSearchStoreFragment().findStores(postalCode);
    }


}