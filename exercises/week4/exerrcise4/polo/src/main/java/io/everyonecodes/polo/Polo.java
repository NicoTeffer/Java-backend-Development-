package io.everyonecodes.polo;

import org.springframework.stereotype.Service;

@Service
public class Polo {

    public String poloOrWhat(String message) {
        if (message.equals("Marco")) {
            return "Polo";
        }
        return "What?";
    }
}
