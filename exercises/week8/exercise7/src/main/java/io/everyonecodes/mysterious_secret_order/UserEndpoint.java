package io.everyonecodes.mysterious_secret_order;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserEndpoint {

    private final UserRepository userRepository;
    private final OrderService orderService;

    public UserEndpoint(UserRepository userRepository, OrderService orderService) {
        this.userRepository = userRepository;
        this.orderService = orderService;
    }

    @GetMapping
    @Secured({"ROLE_MASTER", "ROLE_APPRENTICE"})
    String getMsoMessage() {
        return "Mysterious Secret Order";
    }

    @PostMapping("/members")
    @Secured("ROLE_MASTER")
    User post(@RequestBody User user) {
        return orderService.makeUser(user);
    }

    @GetMapping("/members")
    @Secured("ROLE_MASTER")
    List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/members/apprentices")
    @Secured({"ROLE_APPRENTICE","ROLE_MASTER"})
    List<User> getApprentices() {
        return userRepository.findByAuthorities("ROLE_APPRENTICE");
    }
}
