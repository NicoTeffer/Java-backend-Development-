package io.everyonecodes.validation;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtworkRepository extends MongoRepository<Artwork, String> {
}
