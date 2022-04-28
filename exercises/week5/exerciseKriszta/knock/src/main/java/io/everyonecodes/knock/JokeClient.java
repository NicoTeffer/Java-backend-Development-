package io.everyonecodes.knock;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class JokeClient {

    private final RestTemplate restTemplate;
    private final String url = "http://localhost:9001/joke";

    public JokeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String post(String message) {
        return restTemplate.postForObject(url, message, String.class);
    }
}
