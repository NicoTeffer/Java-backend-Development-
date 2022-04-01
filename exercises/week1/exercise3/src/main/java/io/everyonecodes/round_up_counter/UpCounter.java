package io.everyonecodes.round_up_counter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpCounter {

    private final UpDownIndicator upDownIndicator;

    public UpCounter(UpDownIndicator upDownIndicator) {
        this.upDownIndicator = upDownIndicator;
    }

    public int count(List<Double> numberList) {
        List<String> indicateList = new ArrayList<>();
        for (Double number : numberList){
            indicateList.add(upDownIndicator.indicate(number));
        }
        int count = 0;
        for (String string : indicateList){
            if (string.equals("UP")){
                count++;
            }
        }
        return count;
    }
}
