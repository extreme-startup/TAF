package automation.examples.api.model.request;


public class LoginDTO {

    private String email;

    public LoginDTO() {
    }

    public LoginDTO(final String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
