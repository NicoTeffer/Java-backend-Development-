package io.everyonecodes.the_final_countdown;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AccumulationManagerTest {

    @Autowired
    AccumulationManager accumulationManager;

    @MockBean
    AccumulationRepository accumulationRepository;

    @MockBean
    TheFinalCountdownRunner theFinalCountdownRunner;

    @Test
    void accumulateRunsForTheFirstTime() {
        Accumulation accumulation1 = new Accumulation();
        Mockito.when(accumulationRepository.findAll()).thenReturn(List.of(accumulation1));

        accumulationManager.accumulate();

        Mockito.verify(accumulationRepository).count();
        Mockito.verify(accumulationRepository).save(accumulation1);

        Mockito.verify(accumulationRepository).findAll();
        Accumulation accumulation2 = new Accumulation(accumulation1.getId(), 1);
        Mockito.verify(accumulationRepository).save(accumulation2);
    }

    @Test
    void accumulateRunsAfterTheFirstTime() {
        Accumulation accumulation1 = new Accumulation("testID", 0);
        Mockito.when(accumulationRepository.count()).thenReturn(1L);
        Mockito.when(accumulationRepository.findAll()).thenReturn(List.of(accumulation1));

        accumulationManager.accumulate();

        Mockito.verify(accumulationRepository).count();
        Mockito.verify(accumulationRepository).findAll();
        Accumulation accumulation2 = new Accumulation(accumulation1.getId(), 1);
        Mockito.verify(accumulationRepository).save(accumulation2);
    }
}