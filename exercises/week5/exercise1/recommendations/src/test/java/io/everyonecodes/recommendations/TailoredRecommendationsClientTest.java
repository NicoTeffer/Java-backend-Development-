package io.everyonecodes.recommendations;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TailoredRecommendationsClientTest {

    @Autowired
    TailoredRecommendationsClient tailoredRecommendationsClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${urls.tailoredrecommendations}")
    String url;

    @Test
    void getTailoredRecommendations() {
        String uuid = "0815";
        Mockito.when(restTemplate.getForObject(url + "/" + uuid, Movie[].class)).thenReturn(new Movie[]{});
        var response = tailoredRecommendationsClient.getTailoredRecommendations(uuid);
        Mockito.verify(restTemplate).getForObject(url + "/" + uuid, Movie[].class);
    }
}