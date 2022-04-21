package io.everyonecodes.marathon_integration;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class MarathonClient {

    private final RestTemplate restTemplate;
    private final String url = "http://localhost:8500";

    public MarathonClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // TODO: Returns the winner of the marathon App call.
    public Runner getWinner() {
        return restTemplate.getForObject(url + "/runners/winner", Runner.class);
    }

    // TODO: Has a method that posts a Runner to the Marathon web app.
    public Runner post(Runner runner) {
        return restTemplate.postForObject(url + "/runners", runner, Runner.class);
    }
}
