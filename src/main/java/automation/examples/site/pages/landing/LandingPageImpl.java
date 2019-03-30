package automation.examples.site.pages.landing;

import automation.examples.site.components.competition.CompetitionFragment;
import automation.examples.site.components.login.LoginFragment;
import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Component
public class LandingPageImpl implements LandingPage {

    @Autowired
    private LoginFragment loginFragment;

    @Autowired
    private CompetitionFragment competitionFragment;

    @Override
    public void openPage() {
        open("/");
    }

    @Override
    public LoginFragment getLoginFragment() {
        return loginFragment;
    }

    @Override
    public CompetitionFragment getCompetitionFragment() { return competitionFragment; }

    @Override
    public boolean isProfileLinkEnabled() {
        return getProfileLink().isEnabled();
    }

    @Override
    public String getProfileEmail() {
        return getProfileLink().getAttribute("innerText");
    }

    private SelenideElement getProfileLink() {
        return $("a#profile");
    }

}
