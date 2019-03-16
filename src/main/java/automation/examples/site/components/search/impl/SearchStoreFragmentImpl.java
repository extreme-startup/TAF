package automation.examples.site.components.search.impl;

import automation.examples.site.components.search.SearchStoreFragment;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class SearchStoreFragmentImpl implements SearchStoreFragment {

    @Override
    public void findStores(final String postalCode) {
        getStoreFinderInput().shouldBe(Condition.enabled).sendKeys(postalCode);
        getFindStoresButton().click();
    }

    private SelenideElement getStoreFinderInput() {
        return $("input.address_finder__field");
    }

    private SelenideElement getFindStoresButton() {
        return $("button.address_finder__btn");
    }

}
