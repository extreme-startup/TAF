package automation.examples.site.pages.home.impl;

import automation.examples.site.components.search.SearchStoreFragment;
import automation.examples.site.pages.home.StoreFinderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.open;

@Component
public class StoreFinderPageImpl implements StoreFinderPage {

    @Autowired
    private SearchStoreFragment searchStoreFragment;

    @Override
    public void openPage() {
        open("/store-finder");
    }

    @Override
    public SearchStoreFragment getSearchStoreFragment() {
        return searchStoreFragment;
    }

}
