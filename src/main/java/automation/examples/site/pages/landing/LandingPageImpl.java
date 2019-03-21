package automation.examples.site.pages.landing;

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


    @Override
    public void openPage() {
        open("/");
    }

    @Override
    public LoginFragment getLoginFragment() {
        return loginFragment;
    }

    @Override
    public boolean isProfileLinkEnabled() {
        return getProfileLink().isEnabled();
    }

    private SelenideElement getProfileLink() {
        return $("a#profile");
    }

}
