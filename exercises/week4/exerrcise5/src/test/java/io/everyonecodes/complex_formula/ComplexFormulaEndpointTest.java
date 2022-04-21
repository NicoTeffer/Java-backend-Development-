package io.everyonecodes.complex_formula;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComplexFormulaEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    ComplexFormula complexFormula;

    String url = "/complexformula";

    @Test
    void post() {
//        int post = 2;
//        int expected = 4;
//        Mockito.when(complexFormula.applyFormulaPerDigit(post)).thenReturn(Optional.of(expected));
//        var response = testRestTemplate.postForObject(url + "2", post, Integer.class);
//        Assertions.assertEquals(expected, response);
//        Mockito.verify(complexFormula).applyFormulaPerDigit(post);
    }
}