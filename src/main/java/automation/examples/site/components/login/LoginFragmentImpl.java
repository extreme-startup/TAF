package automation.examples.site.components.login;

import automation.examples.storage.models.Credentials;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class LoginFragmentImpl implements LoginFragment {

    @Override
    public void login(final Credentials credentials) {
        getLoginInput().sendKeys(credentials.getLogin());
        getPasswordInput().sendKeys(credentials.getPassword());
        getSubmitButton().click();
    }

    private SelenideElement getLoginInput() {
        return $("input#login");
    }

    private SelenideElement getPasswordInput() {
        return $("input#password");
    }

    private SelenideElement getSubmitButton() {
        return $("button#submit");
    }

}
