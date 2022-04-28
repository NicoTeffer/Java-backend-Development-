package io.everyonecodes.tailored_recommendations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TailoredRecommendationsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TailoredRecommendationsStore tailoredRecommendationsStore;

    String url = "/tailoredrecommendations";

    @Test
    void getTailoredRecommendation() {
        var testMovie = new Movie("a", "plota");
        var expected = List.of(testMovie);
        Mockito.when(tailoredRecommendationsStore.getTailoredRecommendation("1")).thenReturn(expected);
        var response = testRestTemplate.getForObject(url + "/" + "1", Movie[].class);
        var responseAsList = List.of(response);
        Assertions.assertEquals(expected, responseAsList);
        Mockito.verify(tailoredRecommendationsStore).getTailoredRecommendation("1");
    }

    @Test
    void post() {
        TailoredRecommendation testRecommendation = new TailoredRecommendation("0815", new Movie("EGAL!", "o.O"));
        testRestTemplate.put(url, testRecommendation);
        tailoredRecommendationsStore.addTailoredRecommendation(testRecommendation);
        Mockito.verify(tailoredRecommendationsStore).addTailoredRecommendation(testRecommendation);
    }
}