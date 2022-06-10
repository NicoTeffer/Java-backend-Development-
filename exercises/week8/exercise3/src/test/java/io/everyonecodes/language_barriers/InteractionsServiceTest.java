package io.everyonecodes.language_barriers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InteractionsServiceTest {

    private InteractionsService interactionsService;

    @BeforeEach
    void setup() {
        interactionsService = new InteractionsService();
    }

    @Test
    void getNumberOfInteractions() {
        var result = interactionsService.getNumberOfInteractions();
        Assertions.assertEquals(0, result);
    }

    @Test
    void increaseNumberOfInteractionsByOne() {
        var initial = interactionsService.getNumberOfInteractions();
        Assertions.assertEquals(0, initial);

        interactionsService.increaseNumberOfInteractionsByOne();

        var result = interactionsService.getNumberOfInteractions();
        Assertions.assertEquals(1, result);
    }

    @Test
    void increaseNumberOfInteractionsBy() {
        var initial = interactionsService.getNumberOfInteractions();
        Assertions.assertEquals(0, initial);

        interactionsService.increaseNumberOfInteractionsBy(5);

        var result = interactionsService.getNumberOfInteractions();
        Assertions.assertEquals(5, result);
    }
}