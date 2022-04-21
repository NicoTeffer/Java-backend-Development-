package io.everyonecodes.complex_formula;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/complexformula")
public class ComplexFormulaEndpoint {

    private final ComplexFormula complexFormula;

    public ComplexFormulaEndpoint(ComplexFormula complexFormula) {
        this.complexFormula = complexFormula;
    }

    @GetMapping("/{number}")
    Optional<Integer> post(@PathVariable int number){
        return complexFormula.applyFormulaPerDigit(number);
    }
}
