package automation.examples.site.pages.landing;

import automation.examples.site.components.login.LoginFragment;
import automation.examples.site.pages.Page;

public interface LandingPage extends Page {

    LoginFragment getLoginFragment();

    boolean isProfileLinkEnabled();
}
