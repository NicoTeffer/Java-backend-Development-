package io.everyonecodes.hot_right_now;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MovieStoreTest {

    @Autowired
    MovieStore movieStore;

    @Test
    void hotrightnowMovies() {
        var result = movieStore.getHotrightnow();
        Movie movie1 = new Movie("a", "plot1");
        Movie movie2 = new Movie("b", "plot2");
        Movie movie3 = new Movie("c", "plot3");
        var expected = List.of(movie1, movie2, movie3);
        Assertions.assertEquals(expected, result);
    }
}