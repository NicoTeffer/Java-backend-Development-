package io.everyonecodes.mongo_rockscissorspaper;

import java.util.List;
import java.util.Random;

public class Computer implements Player {

    private final List<Move> moves;
    private final Random random = new Random();

    public Computer(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public Move play() {
        int size = moves.size();
        int choice = random.nextInt(size);
        return moves.get(choice);
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}

