package io.everyonecodes.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TwitterService {

    private final TweetRepository tweetRepository;
    private final int likesStart;

    public TwitterService(TweetRepository tweetRepository, @Value("${tweet.likesStart}") int likesStart) {
        this.tweetRepository = tweetRepository;
        this.likesStart = likesStart;
    }

    // TODO:GET to “/tweets” -> returns all Tweets ordered by timestamp descending.
    public List<Tweet> getTweets() {
        return tweetRepository.findAllByOrderByTimestampDesc();
    }

    // TODO:GET to “/tweets/user/{user}” -> returns all Tweets of the user ordered by timestamp descending.
    public List<Tweet> getUserTweet(String user) {
        return tweetRepository.findAllByUserOrderByTimestampDesc(user);
    }

    // TODO:POST a Tweet to “/tweets” ->Provides a timestamp to the Tweet, saves it and returns it.
    public Tweet postTweet(Tweet tweet) {
        LocalDateTime now = LocalDateTime.now();
        tweet.setTimestamp(now);
        tweet.setLikes(likesStart);
        tweet.setComments(new ArrayList<>());
        System.out.println("Tweet has been saved!");
        System.out.println("Tweet has 0 likes, yet!");
        return tweetRepository.save(tweet);
    }

    // TODO:PUT to “/tweets/{id}/likes” -> adds one like to the Tweet that matches the id and saves it.
    public void likeUserTweet(String id) {
        Optional<Tweet> userTweet;
        int likes = 0;
        if (ifExists(id)) {
            userTweet = tweetRepository.findById(id);
            likes = userTweet.get().getLikes();
            System.out.println("User has: " + likes + " likes!");
            likes++;
            userTweet.get().setLikes(likes);
            System.out.println("+ 1 like!");
            System.out.println("User now has: " + likes + " likes!");
            tweetRepository.save(userTweet.get());
            return;
        }
        System.out.println("Tweet has been saved with: " + likes + " likes!");
    }

    // TODO:PUT a String to “/tweets/{id}/comments” -> adds one comment to the Tweet that matches the id
    //  and saves it.
    public void addCommentToTweet(String id, String comment) {
        Optional<Tweet> userTweet;
        if (ifExists(id)) {
            userTweet = tweetRepository.findById(id);
            var comments = userTweet.get().getComments();
            comments.add(comment);
            userTweet.get().setComments(comments);
            tweetRepository.save(userTweet.get());
        }
        System.out.println("Comment has been added: " + comment + " !");
    }

    private boolean ifExists(String id) {
        return tweetRepository.findById(id).isPresent();
    }
}