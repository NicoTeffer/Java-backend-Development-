package io.everyonecodes.mongo_rockscissorspaper.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameResultRepository extends MongoRepository<GameResult, String> {
}
