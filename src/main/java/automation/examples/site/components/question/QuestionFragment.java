package automation.examples.site.components.question;

import automation.examples.site.components.Fragment;

public interface QuestionFragment extends Fragment {

    void provideRequiredDetailsForQuestion(String question, String answer, String value);

    void provideAnswerWithValue(String answer, String value);

    void saveQuestion();

    void cancelQuestion();

    void selectStaticType();

    void selectDynamicType();

    boolean isQuestionErrorMessageDisplayed();

    boolean isQuestionHighlighted();

    boolean isAnswerErrorMessageDisplayed();

    boolean isAnswerHighlighted();

    boolean isValueErrorMessageDisplayed();

    boolean isValueHighlighted();

    String getAnswer();

    String getValue();

}
