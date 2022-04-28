package io.everyonecodes.tailored_recommendations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("recommendation")
public class TailoredRecommendationsStore {

    private List<TailoredRecommendation> tailoredrecommendations;

    public void setTailoredrecommendations(List<TailoredRecommendation> tailoredrecommendations) {
        this.tailoredrecommendations = tailoredrecommendations;
    }

    public List<TailoredRecommendation> getTailoredrecommendations() {
        return tailoredrecommendations;
    }

    public void addTailoredRecommendation(TailoredRecommendation tailoredRecommendation) {
        tailoredrecommendations.add(tailoredRecommendation);
    }

    public List<Movie> getTailoredRecommendation(String userUuid) {
        return tailoredrecommendations.stream()
                .filter(rec -> rec.getUserUuid().equals(userUuid))
                .map(TailoredRecommendation::getMovie).toList();
    }
}
