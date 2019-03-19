package automation.examples.site.components.login;

import automation.examples.site.components.Fragment;
import automation.examples.storage.models.Credentials;

public interface LoginFragment extends Fragment {

    void login(Credentials credentials);

}
