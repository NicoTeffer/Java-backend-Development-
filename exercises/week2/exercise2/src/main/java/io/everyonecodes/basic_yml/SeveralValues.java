package io.everyonecodes.basic_yml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeveralValues {

    private List<Integer> numbers;
    private List<Double> decimalNumbers;
    private List<String> words;
    private List<Boolean> choices;

    public SeveralValues(
            @Value("${basic.several.naturalnumbers}") List<Integer> numbers,
            @Value("${basic.several.decimalnumbers}") List<Double> decimalNumbers,
            @Value("${basic.several.words}") List<String> words,
            @Value("${basic.several.choices}") List<Boolean> choices
    ) {
        this.numbers = numbers;
        this.decimalNumbers = decimalNumbers;
        this.words = words;
        this.choices = choices;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public List<Double> getDecimalNumbers(){
        return decimalNumbers;
    }

    public List<String> getWords(){
        return words;
    }

    public List<Boolean> getChoices(){
        return choices;
    }
}
