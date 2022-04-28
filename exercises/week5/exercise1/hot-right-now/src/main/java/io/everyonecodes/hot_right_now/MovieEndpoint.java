package io.everyonecodes.hot_right_now;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MovieEndpoint {

    private final MovieStore movieStore;

    public MovieEndpoint(MovieStore movieStore) {
        this.movieStore = movieStore;
    }

    @GetMapping("/movies")
    List<Movie> getHotRightNow() {
        return movieStore.getHotrightnow();
    }
}
