package io.everyonecodes.trickster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomConfiguration {

    @Bean
    Random random() {
        return new Random();
    }

    // Random random = new Random();
    //    public int getRandom(int bound){
    //        return  random.nextInt(bound);
    //    }
}
