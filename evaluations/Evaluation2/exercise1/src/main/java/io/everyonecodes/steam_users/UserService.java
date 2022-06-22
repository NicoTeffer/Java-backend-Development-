package io.everyonecodes.steam_users;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final Set<String> authorities;


    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       @Value("${user-credentials.authorities}") Set<String> authorities
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorities = authorities;
    }

    //TODO: POST a User to “/users” -> processes the User,
    // saves it in the database and returns it [for apps only]
    public User postUser(User user) {
        return userRepository.findOneByUsername(user.getUsername()).orElseGet(
                () -> create(user));
    }

    private User create(User user) {
        String encoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(encoded);
        user.setAuthorities(authorities);
        return userRepository.save(user);
    }

    public Optional<User> findOneBy(String username) {
        return userRepository.findOneByUsername(username);
    }

    //TODO: POST to “/login” -> returns a String with the message: Login successful [for regular users only]
    public String postLogin(@RequestBody User user) {
        var userFound = userRepository.findOneByUsername(user.getUsername());
        if (userFound.isPresent()) {
            var userFoundName = userFound.get().getUsername();
            var userFoundPw = userFound.get().getPassword();
            var userName = user.getUsername();
            var userPw = user.getPassword();
            if (userName.equals(userFoundName) && userPw.equals(userFoundPw)) {
                return "Login successful";
            } else {
                return "Login unsuccessful";
            }
        }
        return "User not found";
    }
}
