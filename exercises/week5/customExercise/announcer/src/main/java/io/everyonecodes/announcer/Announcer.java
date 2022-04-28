package io.everyonecodes.announcer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class Announcer {

    private final RestTemplate restTemplate;
    private final String playerlobbyUrl;

    public Announcer(RestTemplate restTemplate,
                     @Value("${playerlobby.url}") String playerlobbyUrl
    ) {
        this.restTemplate = restTemplate;
        this.playerlobbyUrl = playerlobbyUrl;
    }

    public String findMatch(){
        String matchUrl = restTemplate.getForObject(playerlobbyUrl,String.class);
        String match = restTemplate.getForObject(matchUrl,String.class);
        return "The next match is: " + match;
    }
}
