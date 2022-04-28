package io.everyonecodes.recommendations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class RecommendationServiceTest {

    @Autowired
    RecommendationService recommendationService;

    @Autowired
    List<Rating> ratings;

    @MockBean
    HotRightNowClient hotRightNowClient;

    @MockBean
    TailoredRecommendationsClient tailoredRecommendationsClient;

    @Test
    void provideRecommendations_Tailored() {
        String uuid = "0815";
        var testListHot = List.of(
                new Movie("a", "plota"),
                new Movie("b", "plotb"),
                new Movie("c", "plotc")
        );
        var testListTailored = List.of(
                new Movie("x", "plotx"),
                new Movie("y", "ploty"),
                new Movie("z", "plotz")
        );
        Mockito.when(hotRightNowClient.getHotRightNowMovies()).thenReturn(testListHot);
        Mockito.when(tailoredRecommendationsClient.getTailoredRecommendations(uuid)).thenReturn(testListTailored);
        var response = recommendationService.provideRecommendations(uuid);
        Assertions.assertEquals(testListTailored, response);
        Mockito.verify(hotRightNowClient).getHotRightNowMovies();
        Mockito.verify(tailoredRecommendationsClient).getTailoredRecommendations(uuid);
    }

    @Test
    void provideRecommendations_HotBackup() {
        String uuid = "0815";
        var testListHot = List.of(
                new Movie("a", "plota"),
                new Movie("b", "plotb"),
                new Movie("c", "plotc")
        );
        var testListTailored = List.of(
                new Movie("x", "plotx"),
                new Movie("y", "ploty"),
                new Movie("z", "plotz")
        );
        Mockito.when(hotRightNowClient.getHotRightNowMovies()).thenReturn(testListHot);
        Mockito.when(tailoredRecommendationsClient.getTailoredRecommendations(uuid)).thenReturn(testListTailored);
        var response = recommendationService.provideRecommendations("1234");
        Assertions.assertEquals(testListHot, response);
        Mockito.verify(hotRightNowClient).getHotRightNowMovies();
        Mockito.verify(tailoredRecommendationsClient).getTailoredRecommendations("1234");
    }

    // TODO: NEEDED MORE TIME ON THIS @ORDER thingy since i didn't want to alter the working code again so late to the deadline
    //  for the exercise, i will study your solution to it though :)
    @Test
    void orderedTest() {
        String uuid = "0815";
        var testListHot = List.of(
                new Movie("a", "plota"),
                new Movie("b", "plotb"),
                new Movie("c", "plotc")
        );
        var testListTailored = List.of(
                new Movie("x", "plotx"),
                new Movie("y", "ploty"),
                new Movie("z", "plotz")
        );
        Mockito.when(hotRightNowClient.provideRecommendation()).thenReturn(testListHot);
        ratings.get(0).provideRecommendation("1234"); // TODO: should return Tailored
        ratings.get(1).provideRecommendation(); // TODO: should return Hot
        var resultSize = ratings.size();
        Assertions.assertEquals(2, resultSize);
        var hotSize = ratings.get(1).provideRecommendation().size();
        Assertions.assertEquals(3, hotSize);
        Mockito.verify(hotRightNowClient, Mockito.times(2)).provideRecommendation();
        Mockito.when(tailoredRecommendationsClient.provideRecommendation(uuid)).thenReturn(testListTailored);
        var response = ratings.get(0).provideRecommendation(uuid);
        Assertions.assertEquals(testListTailored, response);
        Mockito.verify(tailoredRecommendationsClient, Mockito.times(1)).provideRecommendation(uuid);
    }

    @Test
    public void givenOrder_whenInjected_thenByOrderValue() {
        String uuid = "0815";
        var testListHot = List.of(
                new Movie("a", "plota"),
                new Movie("b", "plotb"),
                new Movie("c", "plotc")
        );
        var testListTailored = List.of(
                new Movie("x", "plotx"),
                new Movie("y", "ploty"),
                new Movie("z", "plotz")
        );
        Mockito.when(tailoredRecommendationsClient.provideRecommendation(uuid)).thenReturn(testListTailored);
        Mockito.when(hotRightNowClient.provideRecommendation()).thenReturn(testListHot);
        Assertions.assertEquals(ratings.get(0).provideRecommendation(uuid), testListTailored);
        Assertions.assertEquals(ratings.get(1).provideRecommendation(), testListHot);
        Mockito.verify(tailoredRecommendationsClient).provideRecommendation(uuid);
        Mockito.verify(hotRightNowClient).provideRecommendation();
    }
}