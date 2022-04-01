package io.everyonecodes.fizzbuzz;

import io.everyonecodes.fizzbuzz.services.FizzBuzz;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzTest {

    @Autowired
    FizzBuzz fizzBuzz;

    @ParameterizedTest
    @CsvSource({
            "Fizz,3",
            "Buzz,5",
            "FizzBuzz,15",
            "FizzBuzz,30",
            "FizzBuzz,0",
            "1,1",
            "2,2"
    })
    void apply (String expected, int number){

        String result = fizzBuzz.apply(number);

        assertEquals(expected,result);
    }

}