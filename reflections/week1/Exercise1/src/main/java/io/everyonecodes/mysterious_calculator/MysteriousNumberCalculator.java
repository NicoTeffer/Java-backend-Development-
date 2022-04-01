package io.everyonecodes.mysterious_calculator;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MysteriousNumberCalculator {

    private final Set<MysteriousAddition> mysteriousAdditionSet;
    private final MysteriousNumberFormatter mysteriousNumberFormatter;

    public MysteriousNumberCalculator(Set<MysteriousAddition> mysteriousAdditionSet, MysteriousNumberFormatter mysteriousNumberFormatter) {
        this.mysteriousAdditionSet = mysteriousAdditionSet;
        this.mysteriousNumberFormatter = mysteriousNumberFormatter;
    }

    public String calculate(int number) {
        for (MysteriousAddition mysteriousAddition : mysteriousAdditionSet){
           number = mysteriousAddition.apply(number);
        }
        return mysteriousNumberFormatter.format(number);
    }

}
