package io.everyonecodes.marco;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class PoloClient {

    private final RestTemplate restTemplate;
    private final String urlPolo = "http://localhost:9001/polo";

    public PoloClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String post(String message){
        return restTemplate.postForObject(urlPolo, message, String.class);
    }
}
