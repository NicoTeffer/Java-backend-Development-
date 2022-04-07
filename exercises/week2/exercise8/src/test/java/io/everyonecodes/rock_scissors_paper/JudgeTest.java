package io.everyonecodes.rock_scissors_paper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JudgeTest {

    Judge judge = new Judge();

    static Stream<Arguments> parameters() {
        Move move1 = new Move("move 1", "move 2");
        Move move2 = new Move("move 2", "move 3");
        Move move3 = new Move("move 3", "move 1");
        return Stream.of(
                Arguments.of("Tie!", move1, move1),
                Arguments.of("U win!", move1, move2),
                Arguments.of("Computer wins!", move1, move3)
                );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void judge(String expected, Move move1, Move move2) {
        var result = judge.judge(move1, move2);
        Assertions.assertEquals(expected, result);
    }
}