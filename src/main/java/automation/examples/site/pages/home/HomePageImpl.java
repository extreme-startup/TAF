package automation.examples.site.pages.home;

import automation.examples.site.components.competition.CompetitionFragment;
import automation.examples.site.components.login.LoginFragment;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@Component
public class HomePageImpl implements HomePage {

    @Autowired
    private CompetitionFragment competitionFragment;

    @Autowired
    private Logger logger;

    @Autowired
    private LoginFragment loginFragment;

    @Override
    public LoginFragment getLoginFragment() {
        return loginFragment;
    }

    @Override
    public void openPage() {
        logger.debug("Logger works!");
        open("/");
    }

    @Override
    public SelenideElement getLogoLink() {
        return $(".logo");
    }

    @Override
    public void navigateViaLogoLink() {
        getLogoLink().shouldBe(visible).click();
    }

    @Override
    public CompetitionFragment getCompetitionFragment() {
        return competitionFragment;
    }

    @Override
    public boolean isProfileLinkEnabled() {
        return getProfileLink().isEnabled();
    }

    @Override
    public String getProfileEmail() {
        return getProfileLink().getAttribute("innerText");
    }

    @Override
    public void clickCompetitionLink(final String name) {
        getCompetitionLinks().findBy(exactText(name)).scrollTo().click();
    }

    private ElementsCollection getCompetitionLinks() {
        return $$("a[href*='/training/']");
    }

    private SelenideElement getProfileLink() {
        return $("a#profile");
    }

}
