package io.everyonecodes.amazing_multilingual_hello_world;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("translatedtexts")
public class LanguageFinder {

    private List<Translation> translations;

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    @Bean
    List<Translation> translations() {
        return translations;
    }

    public String checkLanguage(String language) {
        return translations.stream()
                .filter(x -> x.getLanguage().equalsIgnoreCase(language))
                .map(Translation::getText)
                .findFirst().orElse("lupus");
//        for (Translation x : translations) {
//            if (x.getLanguage().equalsIgnoreCase(language)) {
//                return x.getText();
//            }
//        }
//        return "lupus";
    }
}
