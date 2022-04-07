package io.everyonecodes.rock_scissors_paper;

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
            System.out.println("Choose a move! These are your options: " + moveUtils.getNames());
            String choice = scanner.nextLine();
            oMove = moveUtils.getOne(choice);
        }
        return oMove.get();
    }

    @Override
    public boolean wantsToPlayAgain() {
        System.out.println("Want another try? (y, n)");
        String choice = scanner.nextLine();
        return "y".equalsIgnoreCase(choice);
    }
}
