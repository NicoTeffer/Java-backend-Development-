package io.everyonecodes.json_placeholder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostEndpointIntegrationTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    JsonPlaceholderClient jsonPlaceholderClient;

    String url = "/posts";

    Post post = new Post("title", "content", 1, 2);

    @Test
    void getAll() {
        restTemplate.getForObject(url, Post[].class);

        Mockito.verify(jsonPlaceholderClient).getAll();
    }

    @Test
    void getOne() {
        restTemplate.getForObject(url + "/0", Post.class);

        Mockito.verify(jsonPlaceholderClient).getOne(0);
    }

    @Test
    void post() {
        restTemplate.postForObject(url, post, Post.class);

        Mockito.verify(jsonPlaceholderClient).post(post);
    }

    @Test
    void put() {
        restTemplate.put(url + "/0", post);

        Mockito.verify(jsonPlaceholderClient).put(0, post);
    }

    @Test
    void deleteAll() {
        restTemplate.delete(url);

        Mockito.verify(jsonPlaceholderClient).delete();
    }

    @Test
    void deleteOne() {
        restTemplate.delete(url + "/0");

        Mockito.verify(jsonPlaceholderClient).delete(0);
    }
}