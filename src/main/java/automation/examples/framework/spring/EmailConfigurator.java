package automation.examples.framework.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EmailConfigurator {

    @Value("${user.login}")
    private String userLogin;

    public String getEmail() {
        Date date = new Date();
        long timestamp = date.getTime();
        return userLogin.replace("@", String.format("%d@", timestamp));
    }

}
