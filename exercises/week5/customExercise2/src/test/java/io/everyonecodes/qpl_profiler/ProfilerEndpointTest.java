package io.everyonecodes.qpl_profiler;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProfilerEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    ProfilerService profilerService;

    @Value("${test.url}")
    String url;

    @Value("${test.update}")
    String totalEarningsUrl;

    @Value("${test.id}")
    String id;

    @Value("${test.newEarning}")
    int newEarnings;

    @Test
    void getPlayers() {
        testRestTemplate.getForObject(url, Player[].class);

        Mockito.verify(profilerService).playerList();
    }

    @Test
    void getPlayerById() {
        testRestTemplate.getForObject(url + "/" + id, Optional.class);

        Mockito.verify(profilerService).getPlayerById(id);
    }

    @Test
    void postPlayer() {
        Player player = new Player("test", 1, "a", "b", "c", 123);

        testRestTemplate.postForObject(url, player, Player.class);

        Mockito.verify(profilerService).postPlayer(player);
    }

    @Test
    void putNewEarnings() {
        testRestTemplate.put(url + "/" + id + totalEarningsUrl, newEarnings, Optional.class);

        Mockito.verify(profilerService).updateTotalEarnings(id, newEarnings);
    }

    @Test
    void getPlayersByEarnings() {
        int earningsAbove = 1000;
        String url = "/profiler/totalEarnings/";
        testRestTemplate.getForObject(url + earningsAbove, Player[].class);

        Mockito.verify(profilerService).findPlayersWithEarningsAbove(earningsAbove);
    }

    @Test
    void getPlayersByTotalEarningsDesc() {
        String url = "/profiler/totalEarnings";
        testRestTemplate.getForObject(url, Player[].class);

        Mockito.verify(profilerService).findByOrderByTotalEarningsDesc();
    }

    @Test
    void getPlayersByTeam() {
        String teamName = "Team Liquid";
        String url = "/profiler/teams/";
        testRestTemplate.getForObject(url + teamName, Optional.class);

        Mockito.verify(profilerService).findByTeam(teamName);
    }

    @Test
    void deletePlayer() {
        testRestTemplate.delete(url + "/" + id);

        Mockito.verify(profilerService).deletePlayer(id);
    }
}