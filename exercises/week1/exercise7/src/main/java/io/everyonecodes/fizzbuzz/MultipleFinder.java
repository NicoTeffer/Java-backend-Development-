package io.everyonecodes.fizzbuzz;

public class MultipleFinder {

    private int multiple;

    public MultipleFinder(int multiple) {
        this.multiple = multiple;
    }

    public boolean isMultiple(int naturalNumber){
        return naturalNumber % multiple == 0;
    }
}
