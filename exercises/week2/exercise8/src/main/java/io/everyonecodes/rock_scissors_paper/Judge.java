package io.everyonecodes.rock_scissors_paper;

import org.springframework.stereotype.Service;

@Service
public class Judge {

    public String judge(Move move1, Move move2) {
        if (move1.getName().equals(move2.getName())) {
            return "Tie!";
        }
        if (move1.getDefeats().contains(move2.getName())) {
            return "U win!";
        }
        return "Computer wins!";
    }
}
