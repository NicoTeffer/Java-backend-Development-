package io.everyonecodes.recommendations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@Component
@Order(1)
public class TailoredRecommendationsClient implements Rating{

    private final RestTemplate restTemplate;
    private final String url;

    public TailoredRecommendationsClient(RestTemplate restTemplate,
                                         @Value("${urls.tailoredrecommendations}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public List<Movie> getTailoredRecommendations(String uuid) {
        var response = restTemplate.getForObject(url + "/" + uuid, Movie[].class);
        return Stream.of(response).collect(Collectors.toList());
    }

    @Override
    public List<Movie> provideRecommendation() {
        return null;
    }

    @Override
    public List<Movie> provideRecommendation(String uuid) {
        return getTailoredRecommendations(uuid);
    }
}
