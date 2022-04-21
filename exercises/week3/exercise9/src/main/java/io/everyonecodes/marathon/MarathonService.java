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

<<<<<<< HEAD
    // TODO: Has the add method that receives a Runner and adds it to runners.
=======
    //TODO: Has the add method that receives a Runner and adds it to runners.
>>>>>>> 5eee3ab234b36417c5f0a7009275f70d2352c88b
    public void add(Runner runner) {
        runners.add(runner);
    }

<<<<<<< HEAD
    // TODO: Has the findWinner method that returns the Runner with the shortest duration.
=======
    //TODO: Has the findWinner method that returns the Runner with the shortest duration.
>>>>>>> 5eee3ab234b36417c5f0a7009275f70d2352c88b
    // NOTE: Only in the case of endpoints providing single elements, if there is no element to return, it’s fine to return null.
    public Optional<Runner> findWinner() {
        return runners.stream()
                .min(Comparator.comparing(Runner::getDuration));
    }

<<<<<<< HEAD
    // TODO: Has the getRunners default method that returns the runners (provided to facilitate testing).
=======
    //TODO: Has the getRunners default method that returns the runners (provided to facilitate testing).
>>>>>>> 5eee3ab234b36417c5f0a7009275f70d2352c88b
    public Set<Runner> getRunners() {
        return runners;
    }
}
