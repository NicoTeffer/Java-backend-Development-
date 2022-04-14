package io.everyonecodes.music_station;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MusicStationTest {

    @Autowired
    MusicStation musicStation;

    @Test
    void findAll() {
        var result = musicStation.findAll();
        var expected = List.of(
                new Song("1","A"),
                new Song("2", "A"),
                new Song("3","B"),
                new Song("4","B"),
                new Song("5","C")
        );
        Assertions.assertEquals(expected, result);
    }

    @Test
    void findBy() {
        var result = musicStation.findBy("B");
        var expected = List.of(
                new Song("3","B"),
                new Song("4", "B")
        );
        Assertions.assertEquals(expected, result);
    }
}