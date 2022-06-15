package io.everyonecodes.validation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
public class ArtworkEndpoint {

    private final ArtworkRepository artworkRepository;

    public ArtworkEndpoint(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    //TODO:
    //Has the endpoint mapping: POST an Artwork to “/artworks” -> returns the Artwork.
    @PostMapping("/artworks")
    Artwork post(@Valid @RequestBody Artwork artwork){
       return artworkRepository.save(artwork);
    }

}
