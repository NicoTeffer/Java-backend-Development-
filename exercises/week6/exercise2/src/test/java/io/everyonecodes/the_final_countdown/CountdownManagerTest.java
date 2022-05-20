package io.everyonecodes.the_final_countdown;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CountdownManagerTest {

    @Autowired
    CountdownManager countdownManager;

    @MockBean
    CountdownRepository countdownRepository;

    @MockBean
    AccumulationManager accumulationManager;

    @MockBean
    TheFinalCountdownRunner theFinalCountdownRunner;

    @Value("${countdown.start}")
    int countdownStart;

    @Test
    void countdown() {
        countdownManager.countdown();

        Mockito.verify(countdownRepository).count();
        Countdown countdown = new Countdown(countdownStart);
        Mockito.verify(countdownRepository).save(countdown);
        Mockito.verify(countdownRepository, Mockito.never()).findAll();
        Mockito.verify(countdownRepository, Mockito.never()).delete(countdown);
        Mockito.verify(accumulationManager, Mockito.never()).accumulate();
    }

    @Test
    void countReducesCountdown() {
        Countdown countdown1 = new Countdown(1);
        Mockito.when(countdownRepository.count()).thenReturn(1L);
        Mockito.when(countdownRepository.findAll()).thenReturn(List.of(countdown1));

        countdownManager.countdown();

        Mockito.verify(countdownRepository).count();
        Mockito.verify(countdownRepository).findAll();
        Countdown countdown2 = new Countdown(0);
        Mockito.verify(countdownRepository, Mockito.never()).save(countdown2);
        Mockito.verify(countdownRepository).delete(countdown2);
        Mockito.verify(accumulationManager).accumulate();
    }

    @Test
    void countRemovesCountdown() {
        Countdown countdown = new Countdown(1);
        Mockito.when(countdownRepository.count()).thenReturn(1L);
        Mockito.when(countdownRepository.findAll()).thenReturn(List.of(countdown));

        countdownManager.countdown();

        Mockito.verify(countdownRepository).count();
        Mockito.verify(countdownRepository).findAll();
        Countdown countdown3 = new Countdown(0);
        Mockito.verify(countdownRepository, Mockito.never()).save(countdown3);
        Mockito.verify(countdownRepository).delete(countdown3);
        Mockito.verify(accumulationManager).accumulate();
    }
}