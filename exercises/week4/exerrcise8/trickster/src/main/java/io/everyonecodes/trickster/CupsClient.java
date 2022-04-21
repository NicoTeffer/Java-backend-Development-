package io.everyonecodes.trickster;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class CupsClient {

    private final RestTemplate restTemplate;
    private final List<String> urls;

    public CupsClient(RestTemplate restTemplate, @Value("${cup.urls}") List<String> urls) {
        this.restTemplate = restTemplate;
        this.urls = urls;
    }

    public boolean checkForCoin(int cup) {
        String urlForCup = urls.get(cup);
        return restTemplate.getForObject(urlForCup, Boolean.class);
    }

    public void placeCoin(int cup) {
        String urlForCup = urls.get(cup);
        restTemplate.put(urlForCup, null);
    }

    public void removeCoin(int cup) {
        String urlForCup = urls.get(cup);
        restTemplate.delete(urlForCup);
    }

    public int numberOfCups() {
        return urls.size();
    }
}
