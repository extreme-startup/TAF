package automation.examples.site.components.session;

import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

@Component
public class SessionTabFragmentImpl implements SessionTabFragment {

    @Override
    public void addNewSession() {
        $("div.jtrqRl button").shouldBe(enabled).click();
    }

}
