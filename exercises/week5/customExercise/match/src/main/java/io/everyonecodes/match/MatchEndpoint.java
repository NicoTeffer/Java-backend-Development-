package io.everyonecodes.match;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchEndpoint {

    private final String match;

    public MatchEndpoint(@Value("${match}") String match) {
        this.match = match;
    }

    @GetMapping
    String getMatch(){
        return match;
    }
}
