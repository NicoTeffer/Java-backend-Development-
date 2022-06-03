package io.everyonecodes.qpl_profiler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ProfilerServiceTest {

    @Autowired
    ProfilerService profilerService;

    @MockBean
    PlayerRepository playerRepository;

    @Test
    void playerList() {
        profilerService.playerList();

        Mockito.verify(playerRepository).findAll();
    }

    @Test
    void getPlayerById() {
        String id = "id";

        profilerService.getPlayerById(id);

        Mockito.verify(playerRepository).findById(id);
    }

    @Test
    void postPlayer() {
        Player player = new Player("test", 1, "a", "b", "c", 123);

        profilerService.postPlayer(player);

        Mockito.verify(playerRepository).save(player);
    }

    @Test
    void updateTotalEarnings_DoesNotFindEntry() {
        String id = "id";
        Optional<Player> optionalPlayer = Optional.empty();
        Mockito.when(playerRepository.findById(id)).thenReturn(optionalPlayer);

        var result = profilerService.updateTotalEarnings(id, 123);

        Assertions.assertEquals(optionalPlayer, result);
        Mockito.verify(playerRepository).findById(id);
    }

    @Test
    void updateTotalEarnings_DoesFindEntry() {
        String id = "id";
        Optional<Player> optionalPlayer = Optional.of(new Player(
                "test", 1, "a", "b", "c", 123));
        Mockito.when(playerRepository.findById(id)).thenReturn(optionalPlayer);

        var result = profilerService.updateTotalEarnings(id, 321);

        Assertions.assertEquals(optionalPlayer, result);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(321, result.get().getTotalEarnings());
        Mockito.verify(playerRepository, Mockito.times(2)).findById(id);
        Mockito.verify(playerRepository).save(optionalPlayer.get());
    }

    @Test
    void deletePlayer_DoesNotFindPlayer() {
        String id = "id";

        profilerService.deletePlayer(id);

        Assertions.assertTrue(playerRepository.findById(id).isEmpty());
        Mockito.verify(playerRepository, Mockito.times(2)).findById(id);
    }

    @Test
    void deletePlayer_DoesFindPlayer() {
        String id = "id";
        Optional<Player> optionalPlayer = Optional.of(new Player(
                "test", 1, "a", "b", "c", 123));
        Mockito.when(playerRepository.findById(id)).thenReturn(optionalPlayer);

        profilerService.deletePlayer(id);

        Mockito.verify(playerRepository).findById(id);
        Mockito.verify(playerRepository).deleteById(id);
    }

    @Test
    void findPlayersWithEarningsAbove() {
        int totalEarnings = 1000;
        Player player1 = new Player(
                "test", 1, "a", "b", "c", 3023);
        Player player2 = new Player(
                "test", 1, "a", "b", "c", 2023);
        Player player3 = new Player(
                "test", 1, "a", "b", "c", 1023);
        List<Player> expected = List.of(player1, player2, player3);
        Mockito.when(playerRepository.findByTotalEarningsIsGreaterThan(totalEarnings))
                .thenReturn(expected);

        var response = profilerService.findPlayersWithEarningsAbove(totalEarnings);

        Assertions.assertEquals(expected, response);
        Mockito.verify(playerRepository).findByTotalEarningsIsGreaterThan(totalEarnings);
    }

    @Test
    void findByOrderByTotalEarningsDesc() {
        int totalEarnings = 1000;
        Player player1 = new Player(
                "test", 1, "a", "b", "c", 3023);
        Player player2 = new Player(
                "test", 1, "a", "b", "c", 2023);
        Player player3 = new Player(
                "test", 1, "a", "b", "c", 1023);
        List<Player> expected = List.of(player1, player2, player3);
        Mockito.when(playerRepository.findByOrderByTotalEarningsDesc()).thenReturn(expected);

        var response = profilerService.findByOrderByTotalEarningsDesc();

        Assertions.assertEquals(expected, response);
        Mockito.verify(playerRepository).findByOrderByTotalEarningsDesc();
    }

    @Test
    void findByTeamName() {
        String teamName = "Team Liquid";
        Player player = new Player(
                "test", 1, "a", "b", teamName, 3023);
        var expected = Optional.of(List.of(player));
        Mockito.when(playerRepository.findByTeam(teamName)).thenReturn(expected);

        var response = profilerService.findByTeam(teamName);

        Assertions.assertEquals(expected, response);
        Mockito.verify(playerRepository).findByTeam(teamName);
    }
}