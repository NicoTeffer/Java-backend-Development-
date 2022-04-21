package io.everyonecodes.cup;

import org.springframework.stereotype.Service;

@Service
public class Cup {

    private boolean hasCoin;

    public boolean hasCoin() {
        return hasCoin;
    }

    public void placeCoin() {
        hasCoin = true;
    }

    public void removeCoin() {
        hasCoin = false;
    }
}
