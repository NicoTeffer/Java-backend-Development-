package io.everyonecodes.credit_cards;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CreditCards {

    private final Luhn luhnAlgo;
    private final Set<Issuer> issuers;

    public CreditCards(Luhn luhnAlgo, Set<Issuer> issuers) {
        this.luhnAlgo = luhnAlgo;
        this.issuers = issuers;
    }

    public String inspect(String number){
        if (!luhnAlgo.isValid(number)){
            return "Invalid card!";
        }
        return issuers.stream()
                .filter(issuer -> issuer.issues(number))
                .map(Issuer::getName)
                .findFirst()
                .orElse("Card is not supported.");
    }
}
