package automation.examples.site.components.trainings;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$x;


@Component
public class ConfirmDeletionPopUpImpl implements ConfirmDeletionPopUp {

    @Override
    public SelenideElement getConfirmButton() {
        return $x(".//div[(contains(text(), 'Confirm'))]");
    }

    @Override
    public SelenideElement getCancelButton() {
        return $x(".//div[(contains(text(), 'Cancel'))]");
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
