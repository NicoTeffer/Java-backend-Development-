package io.everyonecodes.polo;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polo")
public class PoloEndpoint {

    private final Polo polo;

    public PoloEndpoint(Polo polo) {
        this.polo = polo;
    }

    @PostMapping
    @Secured({"ROLE_MARCO","ROLE_POLO","ROLE_ADMIN"})
    String post(@RequestBody String message) {
        return polo.poloOrWhat(message);
    }
}
