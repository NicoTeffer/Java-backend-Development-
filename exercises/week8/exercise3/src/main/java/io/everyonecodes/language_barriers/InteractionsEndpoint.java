package io.everyonecodes.language_barriers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interactions")
public class InteractionsEndpoint {

    private final InteractionsService interactionsService;

    public InteractionsEndpoint(InteractionsService interactionsService) {
        this.interactionsService = interactionsService;
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    int getInteractions() {
        return interactionsService.getNumberOfInteractions();
    }
}
