package io.everyonecodes.mocky;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/mocky/texts")
public class MockyTextsEndpoint {

    private final RestTemplate restTemplate;
    private final String oneTextUrl;
    private final String twoTextsUrl;

    public MockyTextsEndpoint(
            RestTemplate restTemplate,
            @Value("${mocky.texts.1}") String oneTextUrl,
            @Value("${mocky.texts.2}") String twoTextsUrl
    ) {
        this.restTemplate = restTemplate;
        this.oneTextUrl = oneTextUrl;
        this.twoTextsUrl = twoTextsUrl;
    }

    @GetMapping("/1")
    String getOne() {
        return restTemplate.getForObject(oneTextUrl, String.class);
    }

    @GetMapping("/2")
    List<String> getTwo() {
        String[] response = restTemplate.getForObject(twoTextsUrl, String[].class);
        //assert response != null;
        return List.of(response);
    }
}
