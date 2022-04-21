package io.everyonecodes.lorem_ipsum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/loremipsum")
public class LoremIpsumEndpoint {

    // Beans:
    // ⭔	LoremIpsumEndpoint. Injects the RestTemplate bean.
    // Uses the RestTemplate to get a String object from the “https://loripsum.net/api” url.
    //Mappings: GET to “/loremipsum”

    private final RestTemplate restTemplate;

    public LoremIpsumEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping()
    String getLoremIpsum(){
        String url = "https://loripsum.net/api";
        return restTemplate.getForObject(url,String.class);
    }
}
