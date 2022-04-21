package io.everyonecodes.marathon_integration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marathon")
public class MarathonIntegrationEndpoint {

    private final MarathonTester marathonTester;

    public MarathonIntegrationEndpoint(MarathonTester marathonTester) {
        this.marathonTester = marathonTester;
    }

    @GetMapping("/integration")
    TestResult getIntegration() {
        return marathonTester.getIntegrationTest();
    }
}
