package automation.examples.site.pages.landing;

import automation.examples.site.components.competition.CompetitionFragment;
import automation.examples.site.components.login.LoginFragment;
import automation.examples.site.pages.Page;

public interface LandingPage extends Page {

    LoginFragment getLoginFragment();

    CompetitionFragment getCompetitionFragment();

    boolean isProfileLinkEnabled();
}
