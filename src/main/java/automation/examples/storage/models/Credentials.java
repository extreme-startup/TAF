package automation.examples.storage.models;

public class Credentials {

    private String login;
    private String password;

    public Credentials() {
    }

    public Credentials(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
