package io.everyonecodes.twitter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TwitterServiceTest {

    @Autowired
    TwitterService twitterService;

    @MockBean
    TweetRepository tweetRepository;

    @Value("${tweet.likesStart}")
    int likesStart;

    @Test
    void getTweets() {
        String id = "testId";
        String user = "testUser";
        String text = "testText";
        String comment1 = "testComment1";
        String comment2 = "testComment2";
        LocalDateTime timestamp = LocalDateTime.now();
        List<String> comments = List.of(comment1, comment2);
        Tweet testTweet = new Tweet(id, user, text, likesStart, comments, timestamp);

        Mockito.when(tweetRepository.findByOrderByTimestampDesc()).thenReturn(List.of(testTweet));

        var response = twitterService.getTweets();

        Assertions.assertEquals(List.of(testTweet), response);
        Mockito.verify(tweetRepository).findByOrderByTimestampDesc();
    }

    @Test
    void getUserTweet() {
        String id = "testId";
        String user = "testUser";
        String text = "testText";
        String comment1 = "testComment1";
        String comment2 = "testComment2";
        LocalDateTime timestamp = LocalDateTime.now();
        List<String> comments = List.of(comment1, comment2);
        Tweet testTweet = new Tweet(id, user, text, likesStart, comments, timestamp);

        Mockito.when(tweetRepository.findByUserByOrderByTimestampDesc(user)).thenReturn(List.of(testTweet));

        var response = twitterService.getUserTweet(user);

        Assertions.assertEquals(List.of(testTweet), response);
        Mockito.verify(tweetRepository).findByUserByOrderByTimestampDesc(user);
    }

    @Test
    void postTweet() {
        String id = "testId";
        String user = "testUser";
        String text = "testText";
        String comment1 = "testComment1";
        String comment2 = "testComment2";
        LocalDateTime timestamp = LocalDateTime.now();
        List<String> comments = List.of(comment1, comment2);
        Tweet testTweet = new Tweet(id, user, text, likesStart, comments, timestamp);

        Mockito.when(tweetRepository.save(testTweet)).thenReturn(testTweet);

        twitterService.postTweet(testTweet);

        Mockito.verify(tweetRepository).save(testTweet);
    }

    @Test
    void likeUserTweet() {
        String id = "testId";
        String user = "testUser";
        String text = "testText";
        String comment1 = "testComment1";
        String comment2 = "testComment2";
        LocalDateTime timestamp = LocalDateTime.now();
        List<String> comments = List.of(comment1, comment2);
        Tweet testTweet = new Tweet(id, user, text, likesStart, comments, timestamp);
        Tweet likedTweet = new Tweet(id, user, text, 1, comments, timestamp);
        Mockito.when(tweetRepository.findById(id)).thenReturn(Optional.of(testTweet));
        Mockito.when(tweetRepository.save(testTweet)).thenReturn(likedTweet);

        twitterService.likeUserTweet(id);
        Assertions.assertEquals(1, testTweet.getLikes());

        Mockito.verify(tweetRepository, Mockito.times(2)).findById(id);
        Mockito.verify(tweetRepository, Mockito.times(1)).save(likedTweet);
    }

    @Test
    void addCommentToTweet() {
        String id = "testId";
        String user = "testUser";
        String text = "testText";
        String comment1 = "testComment1";
        String comment2 = "testComment2";
        LocalDateTime timestamp = LocalDateTime.now();
        List<String> comments1 = new ArrayList<>(List.of(comment1));
        List<String> comments2 = new ArrayList<>(List.of(comment1, comment2));
        Tweet testTweet = new Tweet(id, user, text, likesStart, comments1, timestamp);
        Tweet commentedTweet = new Tweet(id, user, text, 1, comments2, timestamp);

        Mockito.when(tweetRepository.findById(id)).thenReturn(Optional.of(testTweet));
        Mockito.when(tweetRepository.save(testTweet)).thenReturn(commentedTweet);

        twitterService.addCommentToTweet(id, comment2);

        Mockito.verify(tweetRepository,Mockito.times(2)).findById(id);
        Mockito.verify(tweetRepository).save(testTweet);
    }
}