package io.everyonecodes.qpl_profiler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilerService {

    private final PlayerRepository playerRepository;
    private final String newPlayerSavedMessage;
    private final String newTotalEarningsMessage;
    private final String playerDeleted;
    private final String playerNotFound;

    public ProfilerService(PlayerRepository playerRepository,
                           @Value("${profiler.messages.newPlayerSaved}") String newPlayerSavedMessage,
                           @Value("${profiler.messages.totalEarningsUpdated}") String newTotalEarningsMessage,
                           @Value("${profiler.messages.delete}") String playerDeleted,
                           @Value("${profiler.messages.notFound}") String playerNotFound
    ) {
        this.playerRepository = playerRepository;
        this.newPlayerSavedMessage = newPlayerSavedMessage;
        this.newTotalEarningsMessage = newTotalEarningsMessage;
        this.playerDeleted = playerDeleted;
        this.playerNotFound = playerNotFound;
    }

    //TODO: GET to “/profiler” -> returns a list of all the saved Players.
    public List<Player> playerList() {
        return playerRepository.findAll();
    }

    //TODO: GET to “/profiler/{id}” -> returns the Player that matches that id.
    public Optional<Player> getPlayerById(String id) {
        if (ifExists(id)) {
            return playerRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    //TODO: POST a Player to “/profiler” -> saves a new Player and returns it.
    public Player postPlayer(Player player) {
        System.out.println(newPlayerSavedMessage);
        return playerRepository.save(player);
    }

    //TODO: PUT to “/profiler/{id}/totalEarnings” -> updates the totalEarnings of a Player
    // and returns it.
    public Optional<Player> updateTotalEarnings(String id, int newTotalEarnings) {
        Optional<Player> optionalPlayer = getPlayerById(id);
        if (optionalPlayer.isEmpty()) {
            return Optional.empty();
        }
        Player player = optionalPlayer.get();
        player.setTotalEarnings(newTotalEarnings);
        playerRepository.save(player);
        System.out.println(newTotalEarningsMessage);
        return Optional.of(player);
    }

    //TODO: DELETE to “/profiler/{id}” -> deletes the Player that matches the given id.
    public void deletePlayer(String id) {
        if (ifExists(id)) {
            playerRepository.deleteById(id);
            System.out.println(playerDeleted);
        } else {
            System.out.println(playerNotFound);
        }
    }

    //TODO: Find results that exceed a certain total earnings amount.
    public List<Player> findPlayersWithEarningsAbove(int totalEarnings) {
        System.out.println("Showing players with earnings above " + totalEarnings + ": ");
        return playerRepository.findByTotalEarningsIsGreaterThan(totalEarnings);
    }

    //TODO: Get results by total earnings amount, descending.
    public List<Player> findByOrderByTotalEarningsDesc() {
        System.out.println("Showing players sorted by earnings, descending.");
        return playerRepository.findByOrderByTotalEarningsDesc();
    }

    //TODO: Find results by Team name.
    public Optional<List<Player>> findByTeam(String teamName) {
        System.out.println("Showing results by team name - \"" + teamName + "\": ");
        return playerRepository.findByTeam(teamName);
    }

    private boolean ifExists(String id) {
        return playerRepository.findById(id).isPresent();
    }
}
