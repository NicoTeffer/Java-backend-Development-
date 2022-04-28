package io.everyonecodes.recommendations;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class HotRightNowClientTest {

    @Autowired
    HotRightNowClient hotRightNowClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${urls.hotrightnow}")
    String url;

    @Test
    void getHotRightNowMovies() {
        Mockito.when(restTemplate.getForObject(url, Movie[].class)).thenReturn(new Movie[]{});
        var response = hotRightNowClient.getHotRightNowMovies();
        Mockito.verify(restTemplate).getForObject(url, Movie[].class);
    }
}