package io.everyonecodes.trickster;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TricksterEndpoint {

    private final Trickster trickster;

    public TricksterEndpoint(Trickster trickster) {
        this.trickster = trickster;
    }

    @GetMapping("/play")
    String playGame() {
        return trickster.playGame();
    }

    @GetMapping("/choose/{cup}")
    Boolean checkCup(@PathVariable int cup) {
        return trickster.coinCheck(cup);
    }
}
