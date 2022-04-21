package io.everyonecodes.cup;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cup")
public class CupEndpoint {

    Cup cup;

    public CupEndpoint(Cup cup) {
        this.cup = cup;
    }

    @GetMapping
    boolean get() {
        return cup.hasCoin();
    }

    @PutMapping
    void put() {
        cup.placeCoin();
    }

    @DeleteMapping
    void delete() {
        cup.removeCoin();
    }
}
