package io.everyonecodes.advanced_yml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("advanced.several")
public class SeveralValues {

    private List<Integer> naturalNumbers;
    private List<Double> decimalNumbers;
    private List<String> words;
    private List<Boolean> choices;

    public SeveralValues() {
    }

    public SeveralValues(
            List<Integer> naturalNumbers,
            List<Double> decimalNumbers,
            List<String> words,
            List<Boolean> choices
    ) {
        this.naturalNumbers = naturalNumbers;
        this.decimalNumbers = decimalNumbers;
        this.words = words;
        this.choices = choices;
    }

    public List<Integer> getNaturalNumbers() {
        return naturalNumbers;
    }

    public void setNaturalNumbers(List<Integer> naturalNumbers) {
        this.naturalNumbers = naturalNumbers;
    }

    public List<Double> getDecimalNumbers() {
        return decimalNumbers;
    }

    public void setDecimalNumbers(List<Double> decimalNumbers) {
        this.decimalNumbers = decimalNumbers;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<Boolean> getChoices() {
        return choices;
    }

    public void setChoices(List<Boolean> choices) {
        this.choices = choices;
    }
}
