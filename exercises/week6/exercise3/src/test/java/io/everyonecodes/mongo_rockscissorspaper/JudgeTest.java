package io.everyonecodes.mongo_rockscissorspaper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JudgeTest {

    Judge judge = new Judge();

    static Stream<Arguments> parameters() {
        Move move1 = new Move("move1", "move2");
        Move move2 = new Move("move2", "move1");
        Move move3 = new Move("move3", "move1");
        return Stream.of(
                Arguments.of("Nobody wins", move1, move1),
                Arguments.of("Player 1 wins", move1, move2),
                Arguments.of("Player 2 wins", move1, move3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void judge(String expected, Move move1, Move move2) {
        String result = this.judge.judge(move1, move2);

        assertEquals(expected, result);
    }
}
