package io.everyonecodes.lorem_ipsum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    //Configurations:
    // ⭔	RestTemplateConfiguration. Plugs in a RestTemplate bean.

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
