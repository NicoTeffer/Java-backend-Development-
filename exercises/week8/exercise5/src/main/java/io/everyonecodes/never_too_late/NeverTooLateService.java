package io.everyonecodes.never_too_late;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NeverTooLateService {

    private final String message;

    public NeverTooLateService(@Value("${System.message}") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
