package io.everyonecodes.wizard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WizardEndpoint {

    @GetMapping("/wizard")
    String getHomeUrl(){
        return "http://localhost:9002/home"; // TODO: URL of the Home Webapp;
    }
}
