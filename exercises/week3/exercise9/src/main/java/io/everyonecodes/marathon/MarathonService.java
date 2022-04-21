package io.everyonecodes.marathon;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

@Service
public class MarathonService {

    private Set<Runner> runners;

    public MarathonService(Set<Runner> runners) {
        this.runners = runners;
    }

    public void setRunners(Set<Runner> runners) {
        this.runners = runners;
    }

    // TODO: Has the add method that receives a Runner and adds it to runners.
    public void add(Runner runner) {
        runners.add(runner);
    }

    // TODO: Has the findWinner method that returns the Runner with the shortest duration.
    // NOTE: Only in the case of endpoints providing single elements, if there is no element to return, it’s fine to return null.
    public Optional<Runner> findWinner() {
        return runners.stream()
                .min(Comparator.comparing(Runner::getDuration));
    }

    // TODO: Has the getRunners default method that returns the runners (provided to facilitate testing).
    public Set<Runner> getRunners() {
        return runners;
    }
}
