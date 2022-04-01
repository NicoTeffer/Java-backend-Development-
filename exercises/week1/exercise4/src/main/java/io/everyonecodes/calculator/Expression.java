package io.everyonecodes.calculator;

import java.util.Objects;

public class Expression {

    private final String symbol;
    private final double term1;
    private final double term2;

    public Expression(String symbol, double term1, double term2) {
        this.symbol = symbol;
        this.term1 = term1;
        this.term2 = term2;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getTerm1() {
        return term1;
    }

    public double getTerm2() {
        return term2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Double.compare(that.term1, term1) == 0 && Double.compare(that.term2, term2) == 0 && Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, term1, term2);
    }

}
