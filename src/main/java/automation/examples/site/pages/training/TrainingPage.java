package automation.examples.site.pages.training;

import automation.examples.site.components.question.DeleteQuestionFragment;
import automation.examples.site.components.question.QuestionFragment;
import automation.examples.site.pages.Page;

public interface TrainingPage extends Page {

    QuestionFragment getQuestionFragment();

    DeleteQuestionFragment getDeleteQuestionFragment();

    void openNewQuestionFragment();

    void deleteQuestion(String question);

    void editQuestion(String question);

    boolean isAddedQuestionDisplayed(String question);

    boolean isAddedQuestionDisabled(String question);

    boolean isAddedQuestionExist(String question);

}
