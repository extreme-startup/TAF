package automation.examples.storage;

import automation.examples.storage.models.Credentials;
import org.springframework.stereotype.Component;

@Component
public class Storage {

    private Credentials credentials = new Credentials();

    public Credentials getCredentials() {
        return credentials;
    }

    public void storeCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

}
