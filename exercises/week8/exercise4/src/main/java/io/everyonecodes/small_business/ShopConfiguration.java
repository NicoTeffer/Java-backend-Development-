package io.everyonecodes.small_business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfiguration {

    @Bean
    ShopService shopService() {
        return new ShopService(false);
    }

}
