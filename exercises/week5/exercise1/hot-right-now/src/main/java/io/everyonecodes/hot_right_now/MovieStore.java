package io.everyonecodes.hot_right_now;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("movies")
public class MovieStore {

    private List<Movie> hotrightnow;

    public void setHotrightnow(List<Movie> hotrightnow) {
        this.hotrightnow = hotrightnow;
    }

    public List<Movie> getHotrightnow() {
        return hotrightnow;
    }
}
