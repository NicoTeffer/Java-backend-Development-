package io.everyonecodes.mongo_rockscissorspaper.mongodb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GameResultManager {
    private final GameResultRepository gameResultRepository;
    private final String statistic;

    public GameResultManager(GameResultRepository gameResultRepository,
                             @Value("${mongo.statistic}") String statistic) {
        this.gameResultRepository = gameResultRepository;
        this.statistic = statistic;
    }

    public void setStatistic(String message) {
        var newGame = gameResultRepository.count();
        if (newGame < 1) {
            System.out.println(statistic);
        }
        GameResult gameResult = new GameResult(message);
        gameResultRepository.save(gameResult);
        List<GameResult> gameResults = gameResultRepository.findAll();
        gameResults.stream().map(GameResult::getResult)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> {
                    if (value > 0) {
                        System.out.println(key + ": " + value);
                    }
                });
    }

    public void deleteStats() {
        gameResultRepository.deleteAll();
    }
}
