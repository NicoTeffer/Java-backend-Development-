package io.everyonecodes.the_final_countdown;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountdownRepository extends MongoRepository<Countdown, String> {
}
