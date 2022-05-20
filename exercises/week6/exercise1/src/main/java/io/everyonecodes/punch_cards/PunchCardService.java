package io.everyonecodes.punch_cards;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PunchCardService {
    private final PunchCardRepository punchCardRepository;

    public PunchCardService(PunchCardRepository punchCardRepository) {
        this.punchCardRepository = punchCardRepository;
    }

    public void punch() {
        PunchCard punchCard = createPunchCard();
        punchCardRepository.save(punchCard);
        System.out.println("Item saved: " + punchCard);
    }

    private PunchCard createPunchCard() {
        LocalDateTime now = LocalDateTime.now();
        String dayOfTheWeek = now.getDayOfWeek().toString();
        String timeOfDay = now.format(DateTimeFormatter.ISO_TIME);
        return new PunchCard(dayOfTheWeek,timeOfDay);
    }
}
