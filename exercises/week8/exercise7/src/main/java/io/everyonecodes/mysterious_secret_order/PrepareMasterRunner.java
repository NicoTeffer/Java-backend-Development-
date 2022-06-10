package io.everyonecodes.mysterious_secret_order;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class PrepareMasterRunner {

    @Bean
    ApplicationRunner prepareUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String masterName = "master";
            String masterPW = "secret";
            if (!userRepository.existsByUsername(masterName)) {
                String password = passwordEncoder.encode(masterPW);
                User master = new User(masterName, password, Set.of("ROLE_MASTER"));
                userRepository.save(master);
            }
        };
    }
}