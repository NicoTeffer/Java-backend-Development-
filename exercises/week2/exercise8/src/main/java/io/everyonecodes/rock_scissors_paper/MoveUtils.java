package io.everyonecodes.rock_scissors_paper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MoveUtils {

    private final List<Move> moves;

    public MoveUtils(List<Move> moves) {
        this.moves = moves;
    }

    public String getNames() {
        return moves.stream()
                .map(Move::getName)
                .collect(Collectors.joining(", "));
    }

    public Optional<Move> getOne(String name) {
        return moves.stream()
                .filter(move1 -> move1.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
