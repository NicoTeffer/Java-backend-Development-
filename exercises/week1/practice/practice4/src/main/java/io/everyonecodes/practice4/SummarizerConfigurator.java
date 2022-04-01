package io.everyonecodes.practice4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SummarizerConfigurator {

    @Bean
    SimpleCalculation1 simpleCalculation1(){
        return new SimpleCalculation1();
    }

    @Bean
    SimpleCalculation2 simpleCalculation2(){
        return new SimpleCalculation2();
    }

    @Bean
    CalculationSummarizer calculationSummarizer(){
        return new CalculationSummarizer(simpleCalculation1(),simpleCalculation2());
    }
}
