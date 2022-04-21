package io.everyonecodes.marco;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marco")
public class MarcoEndpoint {

    private final PoloClient poloClient;

    public MarcoEndpoint(PoloClient poloClient) {
        this.poloClient = poloClient;
    }

    @GetMapping("/{message}")
    String getMessage(@PathVariable String message) {
        return poloClient.post(message);
    }
}
