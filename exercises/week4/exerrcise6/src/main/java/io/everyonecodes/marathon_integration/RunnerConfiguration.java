package io.everyonecodes.marathon_integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RunnerConfiguration {

    @Bean
    Runner winner() {
        return new Runner();
    }

    @Bean
    Set<Runner> runners() {
        return new HashSet<>();
    }
}
