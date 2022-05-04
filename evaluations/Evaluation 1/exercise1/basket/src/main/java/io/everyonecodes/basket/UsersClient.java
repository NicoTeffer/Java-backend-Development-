package io.everyonecodes.basket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class UsersClient {

    // TODO:  Injects the RestTemplate bean. Has a method that receives a user email,
    //  contacts the Users web app and returns a User if it is received.

    private final RestTemplate restTemplate;
    private final String usersUrl;

    public UsersClient(
            RestTemplate restTemplate,
            @Value("${urls.usersUrl}") String usersUrl
    ) {
        this.restTemplate = restTemplate;
        this.usersUrl = usersUrl;
    }

    public User getUserFromUsersApp(String email) {
        return restTemplate.getForObject(usersUrl + "/users/" + email, User.class);
    }
}
