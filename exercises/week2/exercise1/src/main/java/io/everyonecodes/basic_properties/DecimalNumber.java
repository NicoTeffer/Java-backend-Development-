package io.everyonecodes.basic_properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DecimalNumber {

    private double decimalNumber;

    public DecimalNumber(@Value("${basic.decimalnumber}") double decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public double getDecimalNumber(){
        return decimalNumber;
    }
}
