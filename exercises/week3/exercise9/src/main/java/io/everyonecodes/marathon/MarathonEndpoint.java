package io.everyonecodes.marathon;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/runners")
public class MarathonEndpoint {

    private final MarathonService marathonService;

    public MarathonEndpoint(MarathonService marathonService) {
        this.marathonService = marathonService;
    }

    public MarathonService getMarathonService() {
        return marathonService;
    }

    @PostMapping
    public Runner post(@RequestBody Runner runner) {
        marathonService.add(runner);
        return runner;
    }

    // NOTE: Only in the case of endpoints providing single elements, if there is no element to return, it’s fine to return null.
    @GetMapping("/winner")
    private Runner getWinner() {
        return marathonService.findWinner().orElse(null);
    }
}
