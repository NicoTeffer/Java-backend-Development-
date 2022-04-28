package io.everyonecodes.joke;

import org.springframework.stereotype.Service;

@Service
public class Joke {

    public String jokeOrAliens(String knock) {
        if (knock.equals("Knock")) {
            return "It was aliens!";
        }
        return "You didn't knock!";
    }
}
