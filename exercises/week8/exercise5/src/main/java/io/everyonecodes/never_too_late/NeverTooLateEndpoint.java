package io.everyonecodes.never_too_late;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NeverTooLateEndpoint {

    private final NeverTooLateService neverTooLateService;

    public NeverTooLateEndpoint(NeverTooLateService neverTooLateService) {
        this.neverTooLateService = neverTooLateService;
    }

    @GetMapping
    String getMessage() {
        return neverTooLateService.getMessage();
    }
}
