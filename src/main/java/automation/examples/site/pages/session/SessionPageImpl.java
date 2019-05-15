package automation.examples.site.pages.session;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Component
public class SessionPageImpl implements SessionPage {

    @Override
    public void openPage() {
        open("/");
    }

    @Override
    public void waitForSessionIsCreated() {
        getSessionStatus().shouldHave(text("created"));
    }

    @Override
    public void startSession() {
        getStartButton().shouldBe(enabled).click();
    }

    @Override
    public void waitForSessionIsStarted() {
        getStartButton().shouldBe(disappear);
    }

    @Override
    public void pauseSession() {
        getPauseButton().shouldBe(enabled).click();
    }

    @Override
    public void waitForSessionIsPaused() {
        getPauseButton().shouldBe(disappear);
    }

    @Override
    public void stopSession() {
        getStopButton().shouldBe(enabled).click();
    }

    @Override
    public void waitForSessionIsStopped() {
        getStartButton().shouldBe(disappear);
        getPauseButton().shouldBe(disappear);
        getStopButton().shouldBe(disappear);
    }

    @Override
    public boolean isStartButtonAvailable() {
        return getStartButton().isEnabled();
    }

    @Override
    public boolean isPauseButtonAvailable() {
        return getPauseButton().isEnabled();
    }

    @Override
    public boolean isStopButtonAvailable() {
        return getStopButton().isEnabled();
    }

    @Override
    public String getSessionStatusValue() {
        return getSessionStatus().shouldBe(visible).innerText();
    }

    @Override
    public String getLinkForTrainingSession() {
        return $("input#activeSessionLinkId").shouldBe(visible).getValue();
    }

    private SelenideElement getStartButton() {
        return $x(".//div[text()='START SESSION']");
    }

    private SelenideElement getPauseButton() {
        return $x(".//div[text()='PAUSE SESSION']");
    }

    private SelenideElement getStopButton() {
        return $x(".//div[text()='STOP SESSION']");
    }

    private SelenideElement getSessionStatus() {
        return $("div.md2 div.subheading");
    }

}
