package io.everyonecodes.mysterious_calculator;

public class MysteriousAddition {

    private final int number;

    public MysteriousAddition(int number) {
        this.number = number;
    }

    public int apply(int naturalNumber){
        return number + naturalNumber;
    }

}
