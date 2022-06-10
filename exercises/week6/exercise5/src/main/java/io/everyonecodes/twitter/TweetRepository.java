package io.everyonecodes.twitter;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TweetRepository extends MongoRepository<Tweet, String> {

    //TODO: Has a method that returns a list of Tweet elements already sorted by timestamp
    // in descending order. Has a method that returns a list of Tweet elements that belong to
    // a particular user, already sorted by timestamp in a descending order.
    List<Tweet> findAllByOrderByTimestampDesc();

    List<Tweet> findAllByUserOrderByTimestampDesc(String user);
}
