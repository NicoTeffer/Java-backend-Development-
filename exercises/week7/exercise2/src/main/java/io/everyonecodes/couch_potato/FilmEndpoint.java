package io.everyonecodes.couch_potato;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmEndpoint {

    private final FilmRepository filmRepository;

    public FilmEndpoint(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping
    List<Film> getFilms() {
        return filmRepository.findAll();
    }

    @PostMapping // @Valid = Validation usage for Range / MIN, MAX and @NotEmpty
    Film postFilm(@Valid @RequestBody Film film) {
        return filmRepository.save(film);
    }
}
