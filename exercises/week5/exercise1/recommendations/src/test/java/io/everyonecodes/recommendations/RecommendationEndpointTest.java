package io.everyonecodes.recommendations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecommendationEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RecommendationService recommendationService;

    String url = "/recommendations/";

    @Test
    void getRecommendations() {
        String uuid = "0815";
        Mockito.when(recommendationService.provideRecommendations(uuid)).thenReturn(new ArrayList<>());
        var response = testRestTemplate.getForObject(url + uuid, Movie[].class);
        var result = List.of(response);
        var expected = List.of();
        Assertions.assertEquals(expected, result);
        Mockito.verify(recommendationService).provideRecommendations(uuid);
    }
}