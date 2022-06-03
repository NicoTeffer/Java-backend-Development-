package io.everyonecodes.qpl_profiler;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ProfilerEndpoint {

    private final ProfilerService profilerService;

    public ProfilerEndpoint(ProfilerService profilerService) {
        this.profilerService = profilerService;
    }

    //TODO: GET to “/profiler” -> returns a list of all the saved Players.
    @GetMapping("/profiler")
    List<Player> getPlayers() {
        return profilerService.playerList();
    }

    //TODO: GET to “/profiler/{id}” -> returns the Player that matches that id.
    @GetMapping("/profiler/{id}")
    Optional<Player> getPlayerById(@PathVariable String id) {
        return profilerService.getPlayerById(id);
    }

    //TODO: POST a Player to “/profiler” -> saves a new Player and returns it.
    @PostMapping("/profiler")
    Player postPlayer(@RequestBody Player player) {
        return profilerService.postPlayer(player);
    }

    //TODO: PUT to “/profiler/{id}/totalEarnings” -> updates the totalEarnings of a Player
    // and returns it.
    @PutMapping("/profiler/{id}/totalEarnings")
    Optional<Player> putNewEarnings(@PathVariable String id, @RequestBody int totalEarnings) {
        return profilerService.updateTotalEarnings(id, totalEarnings);
    }

    // TODO: GET to "/profiler/totalEarnings/{earningsAbove}" -> returns a List of Players that matches
    //  a certain earnings threshold.
    @GetMapping("/profiler/totalEarnings/{earningsAbove}")
    List<Player> getPlayersByEarnings(@PathVariable int earningsAbove) {
        return profilerService.findPlayersWithEarningsAbove(earningsAbove);
    }

    // TODO: GET to "/profiler/totalEarnings" -> returns the Players by their earnings, descending.
    @GetMapping("/profiler/totalEarnings")
    List<Player> getPlayersByTotalEarningsDesc() {
        return profilerService.findByOrderByTotalEarningsDesc();
    }

    // TODO: GET to "/profiler/totalEarnings/{earningsAbove}" -> returns a List of Players that matches
    //  a certain earnings threshold.
    @GetMapping("/profiler/teams/{teamName}")
    Optional<List<Player>> getPlayersByTeam(@PathVariable String teamName) {
        return profilerService.findByTeam(teamName);
    }

    //TODO: DELETE to “/profiler/{id}” -> deletes the Player that matches the given id.
    @DeleteMapping("/profiler/{id}")
    void deletePlayer(@PathVariable String id) {
        profilerService.deletePlayer(id);
    }
}
