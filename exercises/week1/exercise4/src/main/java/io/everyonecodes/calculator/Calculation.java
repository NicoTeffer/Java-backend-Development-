package io.everyonecodes.calculator;

import java.util.Optional;

public abstract class Calculation {

    private final String symbol;

    public Calculation(String symbol) {
        this.symbol = symbol;
    }

    public boolean matches(Expression expression) {
        return symbol.equals(expression.getSymbol());
    }

    public abstract Optional<Double> calculate(Expression expression);

    public String getSymbol() {
        return symbol;
    }

}
