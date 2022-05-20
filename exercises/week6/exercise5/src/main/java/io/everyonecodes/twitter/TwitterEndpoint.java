package io.everyonecodes.twitter;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TwitterEndpoint {

    private final TwitterService twitterService;

    public TwitterEndpoint(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    // TODO:GET to “/tweets” -> returns all Tweets ordered by timestamp descending.
    @GetMapping("/tweets")
    List<Tweet> getAllTweets() {
        return twitterService.getTweets();
    }

    // TODO:GET to “/tweets/user/{user}” -> returns all Tweets of the user ordered by timestamp descending.
    @GetMapping("/tweets/user/{user}")
    List<Tweet> getTweetFromUserID(@PathVariable String user) {
        return twitterService.getUserTweet(user);
    }

    // TODO:POST a Tweet to “/tweets” ->Provides a timestamp to the Tweet, saves it and returns it.
    @PostMapping("/tweets")
    Tweet postTweet(@RequestBody Tweet tweet) {
        return twitterService.postTweet(tweet);
    }

    // TODO:PUT to “/tweets/{id}/likes” -> adds one like to the Tweet that matches the id and saves it.
    @PutMapping("/tweets/{id}/likes")
    void putLike(@PathVariable String id) {
        twitterService.likeUserTweet(id);
    }

    // TODO:PUT a String to “/tweets/{id}/comments”
    //  -> adds one comment to the Tweet that matches the id and saves it.
    @PutMapping("/tweets/{id}/comments")
    void put(@PathVariable String id, @RequestBody String comment) {
        twitterService.addCommentToTweet(id, comment);
    }
}
