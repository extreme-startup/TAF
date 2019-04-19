package automation.examples.site.pages.home;

import automation.examples.site.components.login.LoginFragment;
import automation.examples.site.components.trainings.AddNewTrainingPopUp;
import automation.examples.site.components.trainings.ConfirmDeletionPopUp;
import automation.examples.site.components.trainings.TrainingSectionFragment;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Component
public class HomePageImpl implements HomePage {

    @Autowired
    private TrainingSectionFragment trainingSectionFragment;

    @Autowired
    private AddNewTrainingPopUp addNewTrainingPopUp;

    @Autowired
    private ConfirmDeletionPopUp confirmDeletionPopUp;

    @Autowired
    private Logger logger;

    @Autowired
    private LoginFragment loginFragment;

    @Override
    public LoginFragment getLoginFragment() {
        return loginFragment;
    }

    @Override
    public void openPage() {
        logger.debug("Logger works!");
        open("/");
    }

    @Override
    public SelenideElement getLogoLink() {
        return $(".logo");
    }

    @Override
    public void navigateViaLogoLink() {
        getLogoLink().shouldBe(visible).click();
    }

    @Override
    public TrainingSectionFragment getTrainingSectionFragment() {
        return trainingSectionFragment;
    }

    @Override
    public AddNewTrainingPopUp getAddNewTrainingPopUp() {
        return addNewTrainingPopUp;
    }

    @Override
    public ConfirmDeletionPopUp getConfirmDeletionPopUp() {
        return confirmDeletionPopUp;
    }

    @Override
    public SelenideElement getAddNewTrainingPopUpAsSelenideElement() {
        return $("div.dADPtf");
    }

    @Override
    public boolean isProfileLinkEnabled() {
        return getProfileLink().isEnabled();
    }

    @Override
    public String getProfileEmail() {
        return getProfileLink().getAttribute("innerText");
    }

    @Override
    public boolean isAddNewTrainingPopUpDisplayed() {
        return getAddNewTrainingPopUpAsSelenideElement().isDisplayed();
    }

    private SelenideElement getProfileLink() {
        return $("a#profile");
    }

}
