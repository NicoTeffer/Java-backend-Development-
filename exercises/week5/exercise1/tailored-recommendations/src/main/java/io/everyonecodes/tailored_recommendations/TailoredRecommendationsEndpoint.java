package io.everyonecodes.tailored_recommendations;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TailoredRecommendationsEndpoint {

    private final TailoredRecommendationsStore tailoredRecommendationsStore;

    public TailoredRecommendationsEndpoint(TailoredRecommendationsStore tailoredRecommendationsStore) {
        this.tailoredRecommendationsStore = tailoredRecommendationsStore;
    }

    @GetMapping("/tailoredrecommendations/{userUuid}")
    List<Movie> getTailoredRecommendation(@PathVariable String userUuid) {
        return tailoredRecommendationsStore.getTailoredRecommendation(userUuid);
    }

    @PostMapping("/tailoredrecommendations")
    TailoredRecommendation post(@RequestBody TailoredRecommendation tailoredRecommendation) {
        tailoredRecommendationsStore.addTailoredRecommendation(tailoredRecommendation);
        return tailoredRecommendation;
    }
}
