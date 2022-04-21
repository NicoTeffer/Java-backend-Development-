package io.everyonecodes.advanced_types;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class CommunityEventEndpoint {

    private final List<CommunityEvent> events;

    public CommunityEventEndpoint(List<CommunityEvent> events) {
        this.events = events;
    }

    @GetMapping
    public List<CommunityEvent> getEvents() {
        return events;
    }
}
