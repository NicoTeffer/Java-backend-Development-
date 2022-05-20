package io.everyonecodes.mongo_rockscissorspaper;

import org.springframework.stereotype.Service;

@Service
public class Judge {

    public String judge(Move move1, Move move2) {
        if (move1.equals(move2)) {
            return "Game is Tie";
        }
        if (move1.getDefeats().contains(move2.getName())) {
            return "Player wins";
        }
        return "Computer wins";
    }
}

