package io.everyonecodes.threepwood_cinema;

import org.springframework.stereotype.Service;

@Service
public class TemplateEngine {

    private final TemplateMessageFinder templateMessageFinder;

    public TemplateEngine(TemplateMessageFinder templateMessageFinder) {
        this.templateMessageFinder = templateMessageFinder;
    }

    public String customiseMessage(String name) {
        var result = templateMessageFinder.find(name);
        return result.replaceAll("--name--", name);
    }
}
