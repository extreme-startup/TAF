package automation.examples.site.components.trainings;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


@Component
public class AddNewTrainingPopUpImpl implements AddNewTrainingPopUp {

    @Override
    public void provideDetailsForTrainingCreation(final String title, final String description) {
        getTitleInput().sendKeys(title);
        getDescriptionInput().sendKeys(description);
    }

    @Override
    public void saveTrainingCreation() {
        getSaveButton().click();
    }

    @Override
    public void cancelTrainingCreation() {
        getCancelButton().click();
    }

    private SelenideElement getTitleInput() {
        return $("input#competition-title-input");
    }

    private SelenideElement getDescriptionInput() {
        return $("textarea#competition-description-input");
    }

    private SelenideElement getSaveButton() {
        return $x(".//button[div[(contains(text(), \"Save\"))]]");
    }

    private SelenideElement getCancelButton() {
        return $x(".//button[div[(contains(text(), \"Cancel\"))]]");
    }

    @Override
    public boolean isSaveButtonEnabled() {
        return getSaveButton().is(enabled);
    }

}
