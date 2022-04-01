package io.everyonecodes.fizzbuzz;

public class FizzBuzz {

    MultipleFinder multipleOfThree() {
        return new MultipleFinder(3);
    }

    MultipleFinder getMultipleOfFive() {
        return new MultipleFinder(5);
    }

    public String apply(int naturalNumber) {
        if (multipleOfThree().isMultiple(naturalNumber)) {
            return "Fizz";
        } else if (getMultipleOfFive().isMultiple(naturalNumber)) {
            return "Buzz";
        } else if (multipleOfThree().isMultiple(naturalNumber) && getMultipleOfFive().isMultiple(naturalNumber)) {
            return "FizzBuzz";
        } else {
            return String.valueOf(naturalNumber);
        }
    }
}
