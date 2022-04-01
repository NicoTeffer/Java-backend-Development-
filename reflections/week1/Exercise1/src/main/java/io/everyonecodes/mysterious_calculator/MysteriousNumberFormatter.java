package io.everyonecodes.mysterious_calculator;

import org.springframework.stereotype.Service;

@Service
public class MysteriousNumberFormatter {

    public String format(int naturalNumber) {
        return "The mysterious number is " + naturalNumber;
    }
}
