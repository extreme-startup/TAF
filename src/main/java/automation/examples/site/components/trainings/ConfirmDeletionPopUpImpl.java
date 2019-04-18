package automation.examples.site.components.trainings;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;


@Component
public class ConfirmDeletionPopUpImpl implements ConfirmDeletionPopUp {

    @Override
    public SelenideElement getConfirmButton() {
        return $("button.delete");
    }

    @Override
    public SelenideElement getCancelButton() {
        return $("button.cancel");
    }

    @Override
    public void confirmDeletion() {
        getConfirmButton().click();
    }

    @Override
    public void cancelDeletion() {
        getCancelButton().click();
    }

}
