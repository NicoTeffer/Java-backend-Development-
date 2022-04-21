package io.everyonecodes.complex_formula;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComplexFormula {

    private final FormulaClient formulaClient;

    public ComplexFormula(FormulaClient formulaClient) {
        this.formulaClient = formulaClient;
    }

    public Optional<Integer> applyFormulaPerDigit(Integer number) {
        String numberAsString = String.valueOf(number);
        var splitResult = List.of(numberAsString.split(""));
        List<String> workingList = new ArrayList<>();
        for (String string : splitResult) {
            var cache = formulaClient.applyFormula(Integer.parseInt(string));
            workingList.add(String.valueOf(cache));
        }
        var x = String.join("", workingList);
        return Optional.of(Integer.parseInt(x));
    }
}
