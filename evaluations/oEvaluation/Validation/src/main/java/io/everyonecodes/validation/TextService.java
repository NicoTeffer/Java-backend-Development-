package io.everyonecodes.validation;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class TextService {

    public Text getText(@Valid Text text){
       return text;
    }
}
