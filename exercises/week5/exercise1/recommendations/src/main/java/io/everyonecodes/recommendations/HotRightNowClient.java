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
@Order(2)
public class HotRightNowClient implements Rating{

    private final RestTemplate restTemplate;
    private final String url;

    public HotRightNowClient(RestTemplate restTemplate,
                             @Value("${urls.hotrightnow}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public List<Movie> getHotRightNowMovies() {
        var response = restTemplate.getForObject(url, Movie[].class);
        return Stream.of(response).collect(Collectors.toList());
    }

    @Override
    public List<Movie> provideRecommendation() {
        return getHotRightNowMovies();
    }

    @Override
    public List<Movie> provideRecommendation(String uuid) {
        return null;
    }
}
