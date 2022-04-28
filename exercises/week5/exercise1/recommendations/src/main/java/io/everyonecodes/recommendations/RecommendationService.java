package io.everyonecodes.recommendations;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final HotRightNowClient hotRightNowClient;
    private final TailoredRecommendationsClient tailoredRecommendationsClient;


    public RecommendationService(HotRightNowClient hotRightNowClient, TailoredRecommendationsClient tailoredRecommendationsClient) {
        this.hotRightNowClient = hotRightNowClient;
        this.tailoredRecommendationsClient = tailoredRecommendationsClient;
    }

    public List<Movie> provideRecommendations(String uuid) {
        var tailored = tailoredRecommendationsClient.getTailoredRecommendations(uuid);
        var hot = hotRightNowClient.getHotRightNowMovies();
        if (!tailored.isEmpty()) {
            return tailored;
        } else {
            return hot;
        }
    }
}
