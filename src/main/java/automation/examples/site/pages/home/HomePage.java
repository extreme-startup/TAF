package automation.examples.site.pages.home;

import automation.examples.site.components.login.LoginFragment;
import automation.examples.site.components.trainings.AddNewTrainingPopUp;
import automation.examples.site.components.trainings.ConfirmDeletionPopUp;
import automation.examples.site.components.trainings.TrainingSectionFragment;
import automation.examples.site.pages.Page;
import com.codeborne.selenide.SelenideElement;

public interface HomePage extends Page {

    LoginFragment getLoginFragment();

    TrainingSectionFragment getTrainingSectionFragment();

    AddNewTrainingPopUp getAddNewTrainingPopUp();

    ConfirmDeletionPopUp getConfirmDeletionPopUp();

    SelenideElement getLogoLink();

    void navigateViaLogoLink();

    boolean isProfileLinkEnabled();

    String getProfileEmail();

    boolean isAddNewTrainingPopUpDisplayed();

    SelenideElement getAddNewTrainingPopUpAsSelenideElement();

}
