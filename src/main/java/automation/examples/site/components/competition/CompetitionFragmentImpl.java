package automation.examples.site.components.competition;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;


@Component
public class CompetitionFragmentImpl implements CompetitionFragment {

    @Override
    public void provideDetailsForCompetitionCreation(final String title, final String description,
                                                     final String category) {
        getTitleInput().sendKeys(title);
        getDescriptionInput().sendKeys(description);
        getCategoryList().selectOptionByValue(category);
    }

    @Override
    public void submitCompetitionCreation() {
        getSubmitButton().click();
    }

    @Override
    public void discardCompetitionCreation() {
        getDiscardButton().click();
    }

    private SelenideElement getTitleInput() {
        return $("input#title");
    }

    private SelenideElement getDescriptionInput() {
        return $("input#description");
    }

    private SelenideElement getCategoryList() { return $("select#category"); }

    private SelenideElement getSubmitButton() {
        return $("button#submit");
    }

    private SelenideElement getDiscardButton() { return $("button#discard");
    }

}
