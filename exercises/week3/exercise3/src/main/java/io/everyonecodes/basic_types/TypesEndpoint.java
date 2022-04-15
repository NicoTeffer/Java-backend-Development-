package io.everyonecodes.basic_types;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types")
public class TypesEndpoint {

    @GetMapping("/text")
    public String getText() {
        return "Types";
    }

    @GetMapping("/number")
    public int getNumber() {
        return 25920;
    }

    @GetMapping("/choice")
    public boolean getChoice() {
        return false;
    }
}
