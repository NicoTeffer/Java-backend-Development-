package io.everyonecodes.twitter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TwitterEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TwitterService twitterService;

    @Value("${tweet.likesStart}")
    int likesStart;

    @Test
    void getAllTweets() {
        String url = "/tweets";
        String id = "testId";
        String user = "testUser";
        String text = "testText";
        String comment1 = "testComment1";
        String comment2 = "testComment2";
        LocalDateTime timestamp = LocalDateTime.now();
        List<String> comments = List.of(comment1, comment2);
        Tweet testTweet = new Tweet(id, user, text, likesStart, comments, timestamp);

        Mockito.when(twitterService.getTweets()).thenReturn(List.of(testTweet));

        testRestTemplate.getForObject(url, Tweet[].class);

        Mockito.verify(twitterService).getTweets();
    }

    @Test
    void getTweetFromUserID() {
        String url = "/tweets/user/";
        String id = "testId";
        String user = "testUser";
        String text = "testText";
        String comment1 = "testComment1";
        String comment2 = "testComment2";
        LocalDateTime timestamp = LocalDateTime.now();
        List<String> comments = List.of(comment1, comment2);
        Tweet testTweet = new Tweet(id, user, text, likesStart, comments, timestamp);

        Mockito.when(twitterService.getUserTweet(user)).thenReturn(List.of(testTweet));

        testRestTemplate.getForObject(url + user, Tweet[].class);

        Mockito.verify(twitterService).getUserTweet(user);
    }

    @Test
    void postTweet() {
    }

    @Test
    void putLike() {
    }

    @Test
    void put() {
    }
}