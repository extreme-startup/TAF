package automation.examples.site.pages.training;

import automation.examples.site.components.question.DeleteQuestionFragment;
import automation.examples.site.components.question.QuestionFragment;
import automation.examples.site.components.session.SessionTabFragment;
import automation.examples.site.pages.Page;

public interface TrainingPage extends Page {

    QuestionFragment getQuestionFragment();

    SessionTabFragment getSessionTabFragment();

    DeleteQuestionFragment getDeleteQuestionFragment();

    void openNewQuestionFragment();

    void deleteQuestion(String question);

    void editQuestion(String question);

    boolean isAddedQuestionDisplayed(String question);

    boolean isAddedQuestionExist(String question);

    void waitUntilQuestionShouldBeDisappear(String question);

    void waitUntilQuestionShouldBeAppear(String question);

    void switchToSessionTab();

}
