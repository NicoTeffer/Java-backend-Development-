package io.everyonecodes.complex_formula;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComplexFormulaTest {

    @Autowired
    ComplexFormula complexFormula;

    @MockBean
    FormulaClient formulaClient;

    String urlInteractions = "http://localhost:8080/formula";

    @Test
    void applyFormulaPerDigit() {
        Mockito.when(formulaClient.applyFormula(2)).thenReturn(4);
        var response = complexFormula.applyFormulaPerDigit(2);
        var expected = Optional.of(4);
        Assertions.assertEquals(expected, response);
        Mockito.verify(formulaClient).applyFormula(2);
    }
}