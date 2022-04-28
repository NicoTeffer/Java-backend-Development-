package io.everyonecodes.amazing_multilingual_hello_world;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AmazingMultilingualHelloWorldEndpoint {

    private final LanguageFinder languageFinder;

    public AmazingMultilingualHelloWorldEndpoint(LanguageFinder languageFinder) {
        this.languageFinder = languageFinder;
    }

    @RequestMapping("/helloworld/{language}")
    String getHelloWorldInLanguage(@PathVariable String language){
        return languageFinder.checkLanguage(language);
    }
}
