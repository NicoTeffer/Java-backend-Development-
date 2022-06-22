package io.everyonecodes.steam_users;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserEndpoint {

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    // TODO: POST a User to “/users” -> processes the User, saves it in the database
    //  and returns it [for apps only]
    @PostMapping("/users")
    @Secured("ROLE_APP")
    User postUser(@RequestBody User user) {
        return userService.postUser(user);
    }

    // TODO: POST to “/login” -> returns a String with the message: Login successful [for regular users only]
    @PostMapping("/login")
    @Secured("ROLE_REGULAR")
    String postLogin(@RequestBody User user){
        return userService.postLogin(user);
    }

}
