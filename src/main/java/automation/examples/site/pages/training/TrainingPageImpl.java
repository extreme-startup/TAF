package automation.examples.site.pages.training;

import automation.examples.site.components.question.DeleteQuestionFragment;
import automation.examples.site.components.question.QuestionFragment;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@Component
public class TrainingPageImpl implements TrainingPage {

    @Autowired
    private QuestionFragment questionFragment;

    @Autowired
    private DeleteQuestionFragment deleteQuestionFragment;

    @Override
    public void openPage() {
        open("/");
    }

    @Override
    public QuestionFragment getQuestionFragment() {
        return questionFragment;
    }

    @Override
    public DeleteQuestionFragment getDeleteQuestionFragment() {
        return deleteQuestionFragment;
    }

    @Override
    public void openNewQuestionFragment() {
        getAddNewQuestionButton().click();
    }

    @Override
    public void deleteQuestion(final String question) {
        getDeleteButton(question).shouldBe(enabled).scrollTo().click();
    }

    @Override
    public void waitUntilQuestionShouldBeDisappear(final String question) {
        getDeleteButton(question).shouldBe(disappear);
    }

    @Override
    public void waitUntilQuestionShouldBeAppear(final String question) {
        getDeleteButton(question).shouldBe(appear);
    }

    @Override
    public void editQuestion(final String question) {
        getEditButton(question).shouldBe(enabled).scrollTo().click();
    }

    @Override
    public boolean isAddedQuestionDisplayed(final String question) {
        return getAddedQuestions().findBy(text(question)).shouldBe(enabled).isDisplayed();
    }

    @Override
    public boolean isAddedQuestionExist(final String question) {
        return getAddedQuestions().findBy(text(question)).exists();
    }

    private ElementsCollection getAddedQuestions() {
        return $$(By.xpath(".//tbody/tr"));
    }

    private SelenideElement getAddNewQuestionButton() {
        return $("button.lfvxis");
    }

    private SelenideElement getDeleteButton(final String question) {
        final String locator =
                ".//tr[@class='ikBKhu'][.//td[normalize-space(text())='%s']]//button[contains(@class,'error')]";
        return $(By.xpath(String.format(locator, question)));
    }

    private SelenideElement getEditButton(final String question) {
        final String locator =
                ".//tr[@class='ikBKhu'][.//td[normalize-space(text())='%s']]//button[not(contains(@class,'error'))]";
        return $(By.xpath(String.format(locator, question)));
    }

}
