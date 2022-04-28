package io.everyonecodes.tailored_recommendations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TailoredRecommendationsStoreTest {

    @Autowired
    TailoredRecommendationsStore tailoredRecommendationsStore;

    @Test
    void getTailoredRecommendationViaUUID_returnsUUID() {
        var result = tailoredRecommendationsStore.getTailoredRecommendation("1");
        Movie movie1 = new Movie("a", "plota");
        var expected = List.of(movie1);
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(1, result.size());
    }


    @Test
        // TODO: MAJOR MISTAKE : CHECK IF THE ID FOR EXAMPLE IS UNKNOWN!!!
    void getTailoredRecommendationViaUUID_returnsNONE() {
        var result = tailoredRecommendationsStore.getTailoredRecommendation("0815");
        var expected = List.of();
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(0, result.size());
    }

    @DirtiesContext  // Resets Application Context after this Method (Returns the original YML List)!
    @Test
    void addTailoredRecommendation() {
        Assertions.assertEquals(2, tailoredRecommendationsStore.getTailoredrecommendations().size());
        Movie movie = new Movie("c", "plotc");
        TailoredRecommendation testAddition = new TailoredRecommendation("3", movie);
        tailoredRecommendationsStore.addTailoredRecommendation(testAddition);
        Movie movie1 = new Movie("a", "plota");
        TailoredRecommendation tailoredRecommendation1 = new TailoredRecommendation("1", movie1);
        Movie movie2 = new Movie("b", "plotb");
        TailoredRecommendation tailoredRecommendation2 = new TailoredRecommendation("2", movie2);
        var expected = List.of(tailoredRecommendation1, tailoredRecommendation2, testAddition);
        var result = tailoredRecommendationsStore.getTailoredrecommendations();
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(3, result.size());
    }

    @Test
    void tailoredRecommendation() {
        var result = tailoredRecommendationsStore.getTailoredrecommendations();
        var resultSize = tailoredRecommendationsStore.getTailoredrecommendations().size();
        Movie movie1 = new Movie("a", "plota");
        TailoredRecommendation tailoredRecommendation1 = new TailoredRecommendation("1", movie1);
        Movie movie2 = new Movie("b", "plotb");
        TailoredRecommendation tailoredRecommendation2 = new TailoredRecommendation("2", movie2);
        var expected = List.of(tailoredRecommendation1, tailoredRecommendation2);
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(2, resultSize);
    }
}