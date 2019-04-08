package automation.examples.api.model.requestform;


public class LoginForm {

    private String email;

    public LoginForm() {
    }

    public LoginForm(final String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
