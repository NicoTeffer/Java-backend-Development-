package io.everyonecodes.marathon_integration;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Set;

@Service
public class MarathonTester {

    private final MarathonClient marathonClient;
    private Runner winner;
    private final Set<Runner> runners;

    public MarathonTester(MarathonClient marathonClient, Runner winner, Set<Runner> runners) {
        this.marathonClient = marathonClient;
        this.winner = winner;
        this.runners = runners;
    }

    public TestResult getIntegrationTest() {
        winner = marathonClient.getWinner();
        if (!(winner == null)) {
            return new TestResult(
                    "Error", "No winner should have been received in the first call");
        }
        Runner runner1 = new Runner("Test1", Duration.parse("PT1H1M34S"));
        Runner runner2 = new Runner("Test2", Duration.parse("PT1H1M32S"));
        Runner runner3 = new Runner("Test3", Duration.parse("PT1H1M30S"));
        runners.add(marathonClient.post(runner1));
        runners.add(marathonClient.post(runner2));
        runners.add(marathonClient.post(runner3));
        winner = marathonClient.getWinner();
        if (winner.equals(runner3)) {
            return new TestResult("Success", "Tests run correctly");
        } else {
            return new TestResult("Error", "Incorrect winner received");
        }
    }
}
