package automation.examples.site.components.trainings;

import automation.examples.site.components.Fragment;

public interface AddNewTrainingPopUp extends Fragment {

    void provideDetailsForTrainingCreation(String title, String description);

    void saveTrainingCreation();

    void cancelTrainingCreation();

    boolean isSaveButtonEnabled();

}
