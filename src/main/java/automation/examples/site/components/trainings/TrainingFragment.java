package automation.examples.site.components.trainings;

import automation.examples.site.components.Fragment;
import com.codeborne.selenide.SelenideElement;

public interface TrainingFragment extends Fragment {

    SelenideElement getName();

    SelenideElement getDescription();

    SelenideElement getDeleteButton();

    SelenideElement getEditButton();

    void clickDelete();

    void clickEdit();

    String getNameText();

    String getDescriptionText();

}
