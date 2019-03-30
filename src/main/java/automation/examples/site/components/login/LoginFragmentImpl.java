package automation.examples.site.components.login;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

@Component
public class LoginFragmentImpl implements LoginFragment {

    @Override
    public void provideEmail(final String email) {
        getLoginInput().sendKeys(email);
    }

    @Override
    public void login(final String login) {
        getLoginInput().sendKeys(login);
        getSubmitButton().shouldBe(enabled).click();
    }

    @Override
    public boolean isLoginHighlighted() {
        return getLoginInput().getAttribute("class").contains("kfCJBy");
    }

    @Override
    public Boolean isLoginErrorMessageDisplayed() {
        return getLoginErrorMessage().isDisplayed();
    }

    private SelenideElement getLoginInput() {
        return $("input#login");
    }

    private SelenideElement getSubmitButton() {
        return $("button#submit");
    }

    private SelenideElement getLoginErrorMessage() {
        return $("p.ceWzIo");
    }

}
