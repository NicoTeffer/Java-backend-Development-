package io.everyonecodes.joke;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/joke")
public class JokeEndpoint {

    private final Joke joke;

    public JokeEndpoint(Joke joke) {
        this.joke = joke;
    }

    @PostMapping()
    public String post(@RequestBody String message){
        return joke.jokeOrAliens(message);
    }
}
