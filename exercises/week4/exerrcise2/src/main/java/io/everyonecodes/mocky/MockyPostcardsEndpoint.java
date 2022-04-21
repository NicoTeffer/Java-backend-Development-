package io.everyonecodes.mocky;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mocky/postcards")
public class MockyPostcardsEndpoint {

    private final RestTemplate restTemplate;
    private final String onePostcardUrl;
    private final List<String> twoPostcardsUrl;

    public MockyPostcardsEndpoint(
            RestTemplate restTemplate,
            @Value("${mocky.postcards.1}") String onePostcardUrl,
            @Value("${mocky.postcards.2}") List<String> twoPostcardsUrl
    ) {
        this.restTemplate = restTemplate;
        this.onePostcardUrl = onePostcardUrl;
        this.twoPostcardsUrl = twoPostcardsUrl;
    }

    @GetMapping("/1")
    Postcard getOnePostcard() {
        return restTemplate.getForObject(onePostcardUrl, Postcard.class);
    }

    @GetMapping("/2")
    List<Postcard> getTwoPostcards() {
        return twoPostcardsUrl.stream()
                .map(url -> restTemplate.getForObject(url, Postcard.class))
                .collect(Collectors.toList());
    }
}
