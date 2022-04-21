package io.everyonecodes.complex_formula;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class FormulaClient {

    private final RestTemplate restTemplate;

    private String urlInteractions = "http://localhost:8080/formula";

    public FormulaClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public int applyFormula(int oneNumber) {
        return restTemplate.postForObject(urlInteractions, oneNumber, Integer.class);
    }
}
