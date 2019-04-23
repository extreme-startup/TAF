package automation.examples.site.components.trainings;

import automation.examples.site.components.Fragment;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

public interface TrainingSectionFragment extends Fragment {

    SelenideElement getAddNewTrainingButton();

    List<TrainingFragment> getTrainings();

    void clickAddNewTrainingButton();

    boolean isAddedTrainingDisplayed(String trainingName, String trainingDescription);

    TrainingFragment getTrainingByName(String trainingName);

    void clickOnTrainingName(String name);

    void deleteTrainingByName(String trainingName);

    void editTrainingByName(String trainingName);

    void waitForTrainingToAppear(String trainingName);

    void waitForTrainingToDisappear(String trainingName);

}
