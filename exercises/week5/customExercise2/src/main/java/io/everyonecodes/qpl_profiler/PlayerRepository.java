package io.everyonecodes.qpl_profiler;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends MongoRepository<Player, String> {

    //TODO: create some custom Queries
    List<Player> findByTotalEarningsIsGreaterThan(int totalEarnings);
    List<Player> findByOrderByTotalEarningsDesc();
    Optional<List<Player>> findByTeam(String teamName);
}
