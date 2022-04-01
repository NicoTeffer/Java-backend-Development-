package io.everyonecodes.fizzbuzz.services;

public class FizzBuzz {

    private final MultipleFinder multipleOfThree;
    private final MultipleFinder multipleOfFive;

    public FizzBuzz(MultipleFinder multipleOfThree, MultipleFinder multipleOfFive){
        this.multipleOfThree = multipleOfThree;
        this.multipleOfFive = multipleOfFive;
    }

    public String apply (int number){
        if (isMultipleOfThree(number) && isMultipleOfFive(number)){
            return "FizzBuzz";
        }
        if (isMultipleOfThree(number)){
            return "Fizz";
        }
        if(isMultipleOfFive(number)){
            return "Buzz";
        }

        return String.valueOf(number);
    }

    private boolean isMultipleOfThree(int number){
        return multipleOfThree.isMultiple(number);
    }
    private boolean isMultipleOfFive(int number){
        return multipleOfFive.isMultiple(number);
    }
}
