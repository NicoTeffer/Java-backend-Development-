package io.everyonecodes.basket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasketConfiguration {

    private final SummaryCalculator summaryCalculator;

    public BasketConfiguration(SummaryCalculator summaryCalculator) {
        this.summaryCalculator = summaryCalculator;
    }

    @Bean
    Basket basket() {
        return new Basket(summaryCalculator);
    }
}
