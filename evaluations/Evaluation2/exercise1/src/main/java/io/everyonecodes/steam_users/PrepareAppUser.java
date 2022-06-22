package io.everyonecodes.steam_users;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class PrepareAppUser {

    @Bean
    ApplicationRunner prepareUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String userName = "steamapp";
            String userPW = "steamapp";
            if (!userRepository.existsByUsername(userName)) {
                String password = passwordEncoder.encode(userPW);
                User app = new User(userName, password, Set.of("ROLE_APP"));
                userRepository.save(app);
            }
        };
    }
}
