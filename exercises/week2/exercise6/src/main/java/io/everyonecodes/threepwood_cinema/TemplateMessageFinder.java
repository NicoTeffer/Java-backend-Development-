package io.everyonecodes.threepwood_cinema;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateMessageFinder {

    private final List<Template> templates;
    private final String defaultMessage;

    public TemplateMessageFinder(
            List<Template> templates,
            @Value("${cinema.specialoffer.defaultMessage}") String defaultMessage
    ) {
        this.templates = templates;
        this.defaultMessage = defaultMessage;
    }

    public String find(String name) {
        for (Template template : templates) {
            if (name.contains(template.getKeyword())) {
                return template.getMessage();
            }
        }
        return defaultMessage;
    }
}