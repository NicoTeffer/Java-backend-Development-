package io.everyonecodes.knock;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/knock")
public class KnockEndpoint {

    private final JokeClient jokeClient;

    public KnockEndpoint(JokeClient jokeClient) {
        this.jokeClient = jokeClient;
    }

    @GetMapping("/{message}")
    public String getMessage(@PathVariable String message) {
        return jokeClient.post(message);
    }
}
