package io.everyonecodes.announcer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/announcer")
public class AnnouncerEndpoint {

    private final Announcer announcer;

    public AnnouncerEndpoint(Announcer announcer) {
        this.announcer = announcer;
    }

    @GetMapping
    String getMatch() {
        return announcer.findMatch();
    }
}
