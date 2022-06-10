package io.everyonecodes.the_thieves_den;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treasures")
public class TreasureEndpoint {

    private final String message;

    public TreasureEndpoint(@Value("${treasures.message}") String message) {
        this.message = message;
    }

    @GetMapping
    String getMessage() {
        return message;
    }
}
