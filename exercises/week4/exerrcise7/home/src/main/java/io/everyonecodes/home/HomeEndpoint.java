package io.everyonecodes.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeEndpoint {

    @GetMapping("/home")
    public String getKansas() {
        return "Kansas";
    }
}
