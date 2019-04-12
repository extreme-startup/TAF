package automation.examples.site.components.question;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static org.apache.commons.lang3.StringUtils.EMPTY;


@Component
public class QuestionFragmentImpl implements QuestionFragment {

    @Override
    public void provideRequiredDetailsForQuestion(final String question, final String answer, final String value) {
        getQuestionInput().sendKeys(question);
        getAnswerInput().sendKeys(answer);
        getValueInput().sendKeys(value);
    }

    @Override
    public void provideAnswerWithValue(final String answer, final String value) {
        getAnswerInput().sendKeys(answer);
        getValueInput().sendKeys(value);
    }

    @Override
    public void saveQuestion() {
        getSaveButton().click();
    }

    @Override
    public void cancelQuestion() {
        getCancelButton().click();
    }

    @Override
    public void selectStaticType() {
        getStaticTypeButton().click();
    }

    @Override
    public void selectDynamicType() {
        getDynamicTypeButton().click();
    }

    @Override
    public boolean isQuestionErrorMessageDisplayed() {
        return getQuestionErrorMessage().isDisplayed();
    }

    @Override
    public boolean isAnswerErrorMessageDisplayed() {
        return getAnswerErrorMessage().isDisplayed();
    }

    @Override
    public boolean isValueErrorMessageDisplayed() {
        return getValueErrorMessage().isDisplayed();
    }

    @Override
    public boolean isQuestionHighlighted() {
        return isElementHighlighted(getQuestionInput(), "formInputError");
    }

    @Override
    public boolean isAnswerHighlighted() {
        return isElementHighlighted(getAnswerInput(), "formTextAreaError");
    }

    @Override
    public boolean isValueHighlighted() {
        return isElementHighlighted(getValueInput(), "formInputError");
    }

    @Override
    public String getAnswer() {
        return getAnswerInput().getValue();
    }

    @Override
    public String getValue() {
        return getValueInput().getValue();
    }

    private SelenideElement getStaticTypeButton() {
        return $("button.dbZTLp");
    }

    private SelenideElement getDynamicTypeButton() {
        return $("button.kJsYHB");
    }

    private SelenideElement getQuestionInput() {
        return $("input#question-text-input");
    }

    private SelenideElement getQuestionErrorMessage() {
        return $("span#question-text-error");
    }

    private SelenideElement getAnswerInput() {
        return $("textarea#question-answer-input");
    }

    private SelenideElement getAnswerErrorMessage() {
        return $("span#question-answer-error");
    }

    private SelenideElement getValueInput() {
        return $("input#question-value-input");
    }

    private SelenideElement getValueErrorMessage() {
        return $("span#question-value-error");
    }

    private SelenideElement getSaveButton() {
        return $("button#question-save-button");
    }

    private SelenideElement getCancelButton() {
        return $("button#question-cancel-button");
    }

    private boolean isElementHighlighted(final SelenideElement element, final String errorClass) {
        return element.getAttribute("class").contains(errorClass);
    }

}
