package io.everyonecodes.recommendations;

import java.util.List;

//  TODO: TESTING @ORDER | https://www.baeldung.com/spring-order
public interface Rating {
    List<Movie> provideRecommendation();

    List<Movie> provideRecommendation(String uuid);
}
