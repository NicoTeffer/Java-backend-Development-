package io.everyoncecodes.practice3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculationConfigurator {

    @Bean
    SimpleCalculation simpleCalculation(){
        return new SimpleCalculation();
    }
}
