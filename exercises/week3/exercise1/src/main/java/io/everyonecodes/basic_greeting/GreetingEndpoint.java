package io.everyonecodes.basic_greeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingEndpoint {

    @RequestMapping
    public String getMessage(){
        return "Hello there!";
    }
}
