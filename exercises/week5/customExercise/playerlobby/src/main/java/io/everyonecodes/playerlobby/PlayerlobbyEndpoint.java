package io.everyonecodes.playerlobby;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playerlobby")
public class PlayerlobbyEndpoint {

    private final String match;

    public PlayerlobbyEndpoint(@Value("${match.url}") String match) {
        this.match = match;
    }

    @GetMapping
    String getMatch() {
        return match;
    }
}
