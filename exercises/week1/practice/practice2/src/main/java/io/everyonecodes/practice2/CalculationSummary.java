package io.everyonecodes.practice2;

import org.springframework.stereotype.Service;

@Service
public class CalculationSummary {

    private final SimpleCalculation1 simpleCalculation1;
    private final SimpleCalculation2 simpleCalculation2;

    public CalculationSummary(SimpleCalculation1 simpleCalculation1, SimpleCalculation2 simpleCalculation2) {
        this.simpleCalculation1 = simpleCalculation1;
        this.simpleCalculation2 = simpleCalculation2;
    }

    public int calculationSummary(){
        var result1 = simpleCalculation1.calculation1();
        var result2 = simpleCalculation2.calculation2();
        return result1 + result2;
    }
}
