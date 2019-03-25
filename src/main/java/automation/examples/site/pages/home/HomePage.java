package automation.examples.site.pages.home;

import automation.examples.site.components.competition.CompetitionFragment;
import automation.examples.site.components.login.LoginFragment;
import automation.examples.site.pages.Page;
import com.codeborne.selenide.SelenideElement;

public interface HomePage extends Page {

    LoginFragment getLoginFragment();

    CompetitionFragment getCompetitionFragment();

    SelenideElement getLogoLink();

    void navigateViaLogoLink();

    boolean isProfileLinkEnabled();

    String getProfileEmail();

    void clickCompetitionLink(String name);

}
