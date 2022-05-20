package io.everyonecodes.mongo_rockscissorspaper;

import java.util.Optional;
import java.util.Scanner;

public class Human implements Player {

    private final MoveUtils moveUtils;
    private final Scanner scanner = new Scanner(System.in);

    public Human(MoveUtils moveUtils) {
        this.moveUtils = moveUtils;
    }

    @Override
    public Move play() {
        Optional<Move> oMove = Optional.empty();
        while (oMove.isEmpty()) {
            oMove = chooseMove();
        }
        return oMove.get();
    }

    private Optional<Move> chooseMove() {
        System.out.print("Choose a move (" + moveUtils.getNames() + "): ");
        String name = scanner.nextLine();
        return moveUtils.getOne(name);
    }

    @Override
    public boolean wantsToPlayAgain() {
        System.out.print("Do you want to play again? (y, N): ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("y");
    }
}


