package io.everyonecodes.mongo_rockscissorspaper;

import io.everyonecodes.mongo_rockscissorspaper.mongodb.GameResultManager;
import org.springframework.stereotype.Service;

@Service
public class Game {

    private final Player player1;
    private final Player player2;
    private final Judge judge;

    private final GameResultManager gameResultManager;

    public Game(Player player1, Player player2, Judge judge, GameResultManager gameResultManager) {
        this.player1 = player1;
        this.player2 = player2;
        this.judge = judge;
        this.gameResultManager = gameResultManager;
    }

    public void play() {
        boolean playing = true;
        while (playing) {
            playOneRound();
            playing = askPlayers();
        }
    }

    private void playOneRound() {
        Move move1 = player1.play();
        Move move2 = player2.play();
        System.out.println("Player 1 chose: " + move1.getName());
        System.out.println("Player 2 chose: " + move2.getName());
        String message = judge.judge(move1, move2);
        System.out.println(message);
        gameResultManager.setStatistic(message);
    }

    private boolean askPlayers() {
        return player1.wantsToPlayAgain() && player2.wantsToPlayAgain();
    }
}
