package io.everyonecodes.mysterious_secret_order;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByUsername(String username);

    Optional<User> findOneByUsername(String username);

    List<User> findByAuthorities(String ROLE_APPRENTICE);
}
