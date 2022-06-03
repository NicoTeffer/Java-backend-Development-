package io.everyonecodes.the_great_gatsby;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TggRunner {
    @Bean
    ApplicationRunner runner(TggService tggService) {
        return args -> tggService.run();
    }
}

