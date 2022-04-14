package io.everyonecodes.advanced_greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingEndpoint {

    private final String greeting;

    public GreetingEndpoint(
            @Value("${greeting}") String greeting) {
        this.greeting = greeting;
    }

    @GetMapping
    public String getGreeting(){
        return greeting;
    }
}
