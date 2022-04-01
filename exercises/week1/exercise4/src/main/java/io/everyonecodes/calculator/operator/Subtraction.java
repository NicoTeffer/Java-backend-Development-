package io.everyonecodes.calculator.operator;

import io.everyonecodes.calculator.Calculation;
import io.everyonecodes.calculator.Expression;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Subtraction extends Calculation {

    public Subtraction() {
        super("-");
    }

    @Override
    public Optional<Double> calculate(Expression expression) {
        return Optional.of(expression.getTerm1() - expression.getTerm2());
    }

}
