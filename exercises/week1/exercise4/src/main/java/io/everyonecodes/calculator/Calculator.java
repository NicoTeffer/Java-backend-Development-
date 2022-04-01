package io.everyonecodes.calculator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Calculator {

    private final ExpressionParser expressionParser;
    private final List<Calculation> operators;

    public Calculator(ExpressionParser expressionParser, List<Calculation> operators) {
        this.expressionParser = expressionParser;
        this.operators = operators;
    }

    public Optional<Double> calculate(String input) {
        var exp = expressionParser.parse(input);
        var operatorList = operators.stream()
                .map(Calculation::getSymbol).toList();
        if (exp.isPresent()) {
            var expression = exp.get();
            for (Calculation operator : operators) {
                if (operator.matches(expression)) {
                    return operator.calculate(expression);
                }
            }
            throw new IllegalArgumentException("Operator not supported!");
        }
        return Optional.empty();
    }

}
