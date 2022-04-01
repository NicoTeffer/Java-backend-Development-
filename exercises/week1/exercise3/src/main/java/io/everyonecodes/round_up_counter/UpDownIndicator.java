package io.everyonecodes.round_up_counter;

import org.springframework.stereotype.Service;

@Service
public class UpDownIndicator {

    private final Rounder rounder;
    private final double inputNumber = 1.5;

    public UpDownIndicator(Rounder rounder) {
        this.rounder = rounder;
    }

    public String indicate(double indicateNumber) {
        double numberUp = rounder.roundUp(inputNumber);
        double numberDown = rounder.roundDown(inputNumber);
        if (indicateNumber > inputNumber && indicateNumber <= numberUp) {
            return "UP";
        } else if (indicateNumber < inputNumber && indicateNumber >= numberDown) {
            return "DOWN";
        } else {
            return "SAME";
        }
    }
}
