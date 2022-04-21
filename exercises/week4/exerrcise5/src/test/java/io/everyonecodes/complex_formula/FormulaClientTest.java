package io.everyonecodes.complex_formula;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class FormulaClientTest {

    @Autowired
    FormulaClient formulaClient;

    @MockBean
    RestTemplate restTemplate;

    String urlInteractions = "http://localhost:8080/formula";

    @Test
    void applyFormula() {
        int testNumber = 246;
        int expected = 4812;
        Mockito.when(restTemplate.postForObject(urlInteractions, testNumber, Integer.class)).thenReturn(expected);
        var result = formulaClient.applyFormula(testNumber);
        Assertions.assertEquals(expected, result);
        Mockito.verify(restTemplate).postForObject(urlInteractions, testNumber, Integer.class);
    }
}