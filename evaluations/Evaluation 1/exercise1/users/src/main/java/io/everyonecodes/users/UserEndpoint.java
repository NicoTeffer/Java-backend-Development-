package io.everyonecodes.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserEndpoint {

    private final UserStore userStore;

    public UserEndpoint(UserStore userStore) {
        this.userStore = userStore;
    }

    @GetMapping("/users/{email}")
    User get(@PathVariable String email){
        return userStore.getUser(email);
    }
}
