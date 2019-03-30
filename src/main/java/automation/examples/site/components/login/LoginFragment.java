package automation.examples.site.components.login;

import automation.examples.site.components.Fragment;

public interface LoginFragment extends Fragment {

    void provideEmail(String email);

    void login(String login);

    boolean isLoginHighlighted();

    Boolean isLoginErrorMessageDisplayed();

}
