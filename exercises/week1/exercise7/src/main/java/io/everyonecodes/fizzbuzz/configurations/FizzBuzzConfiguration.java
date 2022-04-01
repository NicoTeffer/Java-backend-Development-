package io.everyonecodes.fizzbuzz.configurations;

import io.everyonecodes.fizzbuzz.services.FizzBuzz;
import io.everyonecodes.fizzbuzz.services.MultipleFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FizzBuzzConfiguration {

    @Bean
    FizzBuzz fizzBuzz(MultipleFinder multipleOfThree, MultipleFinder multipleOfFive){
        return new FizzBuzz(multipleOfThree,multipleOfFive);
    }
}
