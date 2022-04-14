package io.everyonecodes.music_station;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class MusicStationEndpoint {

    private final MusicStation musicStation;

    public MusicStationEndpoint(MusicStation musicStation) {
        this.musicStation = musicStation;
    }

    @GetMapping
    public List<Song> getSongs() {
        return musicStation.findAll();
    }

    @GetMapping("/electronic")
    public List<Song> getElectronicSongs() {
        return musicStation.findBy("electronic");
    }

    @GetMapping("/psychedelic rock")
    public List<Song> getPsychedelicRockSongs() {
        return musicStation.findBy("psychedelic rock");
    }

    @GetMapping("/son")
    public List<Song> getSonSongs() {
        return musicStation.findBy("son");
    }
}
