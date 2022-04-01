package io.everyonecodes.calculator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpressionParser {

    public Optional<Expression> parse(String input) {
        List<String> splitInput = List.of(input.split(" "));
        try {
            double term1 = Double.parseDouble(splitInput.get(0));
            String symbol = splitInput.get(1);
            double term2 = Double.parseDouble(splitInput.get(2));
            return Optional.of(new Expression(symbol, term1, term2));
        } catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
