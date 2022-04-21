package io.everyonecodes.interactions;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UppercaseEndpoint {

    @PostMapping("/uppercase")
    String post(@RequestBody String input){
        return input.toUpperCase();
    }
}
