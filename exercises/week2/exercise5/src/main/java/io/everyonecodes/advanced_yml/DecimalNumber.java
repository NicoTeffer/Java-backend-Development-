package io.everyonecodes.advanced_yml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class DecimalNumber {

    private double decimalNumber;

    public DecimalNumber() {
    }

    public DecimalNumber(double decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public double getDecimalNumber() {
        return decimalNumber;
    }

    public void setDecimalNumber(double decimalNumber) {
        this.decimalNumber = decimalNumber;
    }
}
