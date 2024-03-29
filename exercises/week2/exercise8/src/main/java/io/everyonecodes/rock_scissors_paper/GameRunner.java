package io.everyonecodes.rock_scissors_paper;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameRunner {
    @Bean
    ApplicationRunner run(Game game) {
        return args -> game.play();
    }
}
