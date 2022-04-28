package io.everyonecodes.recommendations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class RecommendationEndpoint {

    private final RecommendationService recommendationService;

    public RecommendationEndpoint(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/recommendations/{userUuid}")
    List<Movie> getRecommendations(@PathVariable String userUuid) {
        return recommendationService.provideRecommendations(userUuid);
    }
}
