package io.everyonecodes.punch_cards;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PunchCardServiceTest {

    @Autowired
    PunchCardService punchCardService;

    @MockBean
    PunchCardRepository punchCardRepository;

    @MockBean
    PunchCardRunner punchCardRunner;

    @Test
    void punch() {
        punchCardService.punch();
        Mockito.verify(punchCardRepository).save(Mockito.any(PunchCard.class));
    }
}