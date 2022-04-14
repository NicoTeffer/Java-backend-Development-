package io.everyonecodes.advanced_types;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeEndpoint {

    @GetMapping
    public String getHome() {
        return "These are your Options: " + "</br>" + getFirst() + "</br>" + getSecond();
    }

    private String getFirst() {
        return "<a href=\"http://localhost:8100/academies\">Academies</a>";
    }

    private String getSecond() {
        return "<a href=\"http://localhost:8100/events\">Events</a>";
    }
}
