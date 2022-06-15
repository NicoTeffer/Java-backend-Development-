package io.everyonecodes.validation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArtworkEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    ArtworkEndpoint artworkEndpoint;

    String url = "/artworks";

    @Test
    void post() {
        Artwork artwork = new Artwork("test1", new Rating(4));
        testRestTemplate.postForObject(url, artwork, Artwork.class);
        Mockito.verify(artworkEndpoint).post(artwork);
    }

    @Test
    void postNot() {
        Artwork artwork = new Artwork("te", new Rating(0));
        testRestTemplate.postForObject(url, artwork, Artwork.class);
        Mockito.verify(artworkEndpoint,Mockito.never()).post(artwork);
    }
}