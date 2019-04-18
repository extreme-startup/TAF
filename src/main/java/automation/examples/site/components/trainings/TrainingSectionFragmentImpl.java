package automation.examples.site.components.trainings;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;


@Component
public class TrainingSectionFragmentImpl implements TrainingSectionFragment {

    @Autowired
    ApplicationContext applicationContext;

    public SelenideElement getAddNewTrainingButton() {
        return $x(".//div[(contains(text(), \"Add new training\"))]");
    }

    private ElementsCollection getTrainingFragmentAsSelenideElement(){
        return $$("div.flex.xs4");
    }

    public List<TrainingFragment> getTrainings() {
        List<TrainingFragment> trainingFragments = new ArrayList<>();

        for (SelenideElement trainingFragment : getTrainingFragmentAsSelenideElement()) {
            trainingFragments.add(applicationContext.getBean(TrainingFragment.class, trainingFragment));
        }
        return trainingFragments;
    }

    @Override
    public void clickAddNewTrainingButton() {
        getAddNewTrainingButton().shouldBe(enabled).click();
    }

    @Override
    public boolean isAddedTrainingDisplayed(final String trainingName, final String trainingDescription) {
        return getTrainings().stream().anyMatch(training ->
                training.getName().waitUntil(Condition.appear, 2000).getText().equals(trainingName)
                        && training.getDescriptionText().equals(trainingDescription));
    }

    @Override
    public TrainingFragment getTrainingByName(final String trainingName) {
        return getTrainings().stream()
                .filter(trainingFragment -> trainingFragment.getNameText().equals(trainingName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No such training with name " + trainingName));
    }


    @Override
    public void waitForTrainingToAppear(final String trainingName) {
        $x(format(".//h5[contains(text(), \"%s\")]", trainingName)).shouldBe(exist);
    }

    @Override
    public void clickOnTrainingName(final String trainingName) {
        getTrainingByName(trainingName).getName().click();
    }

    @Override
    public void deleteTrainingByName(final String trainingName) {
        getTrainingByName(trainingName).clickDelete();
    }

    @Override
    public void editTrainingByName(final String trainingName) {
        getTrainingByName(trainingName).clickEdit();
    }

}
