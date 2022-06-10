package io.everyonecodes.the_hotel_room;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HotelEndpoint {

    private final String welcomeToEveryone;
    private final String welcomeToRoom;

    public HotelEndpoint(@Value("${hotel.welcome.everyone}") String welcomeToEveryone,
                         @Value("${hotel.welcome.room}") String welcomeToRoom
    ) {
        this.welcomeToEveryone = welcomeToEveryone;
        this.welcomeToRoom = welcomeToRoom;
    }

    @GetMapping
    String getWelcomeToEveryone() {
        return welcomeToEveryone;
    }

    @GetMapping("/room")
    String getWelcomeToRoom() {
        return welcomeToRoom;
    }
}
