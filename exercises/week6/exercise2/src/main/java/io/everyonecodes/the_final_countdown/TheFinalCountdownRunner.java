package io.everyonecodes.the_final_countdown;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TheFinalCountdownRunner {

    @Bean
    ApplicationRunner runner(CountdownManager countdownManager) {
        return args -> countdownManager.countdown();
    }
}
