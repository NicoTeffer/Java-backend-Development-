package io.everyonecodes.trickster;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;

@Service
public class Trickster {

    private final Random random;
    private final CupsClient cupsClient;

    public Trickster(Random random, CupsClient cupsClient) {
        this.random = random;
        this.cupsClient = cupsClient;
    }

    public String playGame() {
        removeCoins();
        chooseRandomCup();
        return "The cups have been shuffled!";
    }

    private void removeCoins() {
        int cupNumber = cupsClient.numberOfCups();
//        for (int i = 0; i < cupsClient.numberOfCups(); i++) {
//            cupsClient.removeCoin(i);
//        }
        IntStream.range(0, cupNumber).forEach(cupsClient::removeCoin);
    }

    private void chooseRandomCup() {
        int cupNumber = cupsClient.numberOfCups();
        int theChosenCup = random.nextInt(cupNumber);
        cupsClient.placeCoin(theChosenCup);
    }

    public boolean coinCheck(int cup){
        return cupsClient.checkForCoin(cup);
    }
}
