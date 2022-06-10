package io.everyonecodes.mysterious_secret_order;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public OrderService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User makeUser(User user) {
        String userName = user.getUsername();
        String userPw = user.getPassword();
        if (!userRepository.existsByUsername(userName)) {
            String password = passwordEncoder.encode(userPw);
            User userDone = new User(userName, password, user.getAuthorities());
            userRepository.save(userDone);
        }
        return user;
    }
}
