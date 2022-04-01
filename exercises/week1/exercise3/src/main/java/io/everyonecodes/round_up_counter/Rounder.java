package io.everyonecodes.round_up_counter;

import org.springframework.stereotype.Service;

@Service
public class Rounder {

    public double roundUp(double inputNumber) {
        return Math.ceil(inputNumber);
    }

    public double roundDown(double inputNumber) {
        return Math.floor(inputNumber);
    }

}
