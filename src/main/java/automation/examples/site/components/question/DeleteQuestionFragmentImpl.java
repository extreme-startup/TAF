package automation.examples.site.components.question;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class DeleteQuestionFragmentImpl implements DeleteQuestionFragment {

    @Override
    public void cancelDeletion() {
        getCancelButton().click();
    }

    @Override
    public void confirmDeletion() {
        getConfirmButton().click();
    }

    private SelenideElement getCancelButton() {
        return $("button.giogji");
    }

    private SelenideElement getConfirmButton() {
        return $("button.euyXRw");
    }

}
