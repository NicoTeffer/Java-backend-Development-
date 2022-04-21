package io.everyonecodes.dorothy;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class Dorothy {

    private final RestTemplate restTemplate;
    private final String urlWizard = "http://localhost:9001/wizard";

    public Dorothy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String homeIs() {
        String responseWizard = restTemplate.getForObject(urlWizard, String.class);
        assert responseWizard != null;
        String responseHome = restTemplate.getForObject(responseWizard, String.class);
        return "My home is " + responseHome + ".";
    }
}
