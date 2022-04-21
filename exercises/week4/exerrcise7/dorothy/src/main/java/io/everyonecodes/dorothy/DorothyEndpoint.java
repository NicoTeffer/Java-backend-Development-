package io.everyonecodes.dorothy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dorothy")
public class DorothyEndpoint {

    // TODO: ⭔	DorothyEndpoint. Injects the Dorothy bean.
    //  Mappings:
    //  GET to “/dorothy”

    private final Dorothy dorothy;

    public DorothyEndpoint(Dorothy dorothy) {
        this.dorothy = dorothy;
    }

    @GetMapping
    String getDorothyHome(){
        return dorothy.homeIs();
    }
}
