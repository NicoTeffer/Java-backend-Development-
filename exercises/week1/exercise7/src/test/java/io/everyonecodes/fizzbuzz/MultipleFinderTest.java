package io.everyonecodes.fizzbuzz;

import io.everyonecodes.fizzbuzz.services.MultipleFinder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MultipleFinderTest {

    static Stream<Arguments> parameters(){
        return Stream.of(
                Arguments.of(true, new MultipleFinder(1),0),
                Arguments.of(true, new MultipleFinder(1),1),
                Arguments.of(false,new MultipleFinder(3),2),
                Arguments.of(true, new MultipleFinder(2),4),
                Arguments.of(true, new MultipleFinder(2),2)
        );

    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isMultiple(boolean expected, MultipleFinder finder, int number) {

        boolean result = finder.isMultiple(number);

        assertEquals(expected,result);
    }

}