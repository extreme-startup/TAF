package automation.examples.site.components.trainings;

import automation.examples.site.components.Fragment;
import com.codeborne.selenide.SelenideElement;

public interface ConfirmDeletionPopUp extends Fragment {

    SelenideElement getConfirmButton();

    SelenideElement getCancelButton();

    void confirmDeletion();

    void cancelDeletion();

}
