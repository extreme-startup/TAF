package automation.examples.framework.spring;

import automation.examples.api.model.response.UserDTO;
import automation.examples.api.resources.AllUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static automation.examples.framework.spring.utils.RandomUtils.getRandomFromCollection;
import static java.util.Arrays.asList;

@Component
public class CustomerHelper {

    @Autowired
    private AllUsers allUsers;

    public static String userLogin;

    public static String getNewEmail() {
        userLogin = "John.Doe@mail.com";
        long timestamp = new Date().getTime();
        return userLogin.replace("@", String.format("%d@", timestamp));
    }

    public String getRandomRegisteredEmail() {
        final List<UserDTO> allUsersDTO = asList(allUsers.get().as(UserDTO[].class));
        final List<String> registeredEmails = allUsersDTO.stream().map(UserDTO::getEmail).collect(Collectors.toList());
        return getRandomFromCollection(registeredEmails);
    }

}
