package io.everyonecodes.scheduling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {

    private final String message1;
    private final String message2;
    private final String message3;

    public SchedulingService(@Value("${messages.message1}") String message1,
                             @Value("${messages.message2}") String message2,
                             @Value("${messages.message3}") String message3
    ) {
        this.message1 = message1;
        this.message2 = message2;
        this.message3 = message3;
    }

    public String getMessage1() {
        return message1;
    }

    public String getMessage2() {
        return message2;
    }

    public String getMessage3() {
        return message3;
    }
}
