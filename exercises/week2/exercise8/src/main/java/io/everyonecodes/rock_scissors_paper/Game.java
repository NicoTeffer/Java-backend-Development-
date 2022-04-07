package io.everyonecodes.rock_scissors_paper;

import org.springframework.stereotype.Service;

@Service
public class Game {

    private final Player player1;
    private final Player player2;
    private final Judge judge;

    public Game(Player player1, Player player2, Judge judge) {
        this.player1 = player1;
        this.player2 = player2;
        this.judge = judge;
    }

    public void play() {
        boolean gameRunning = true;
        while (gameRunning) {
            playAround();
            gameRunning = askPlayer();
        }
    }

    private void playAround() {
        Move humanMove = player1.play();
        Move computerMove = player2.play();
        System.out.println("Human choice: " + humanMove.getName());
        System.out.println("Computer choice: " + computerMove.getName());
        System.out.println(judge.judge(humanMove, computerMove));
    }

    private boolean askPlayer(){
        return player1.wantsToPlayAgain() && player2.wantsToPlayAgain();
    }
}
