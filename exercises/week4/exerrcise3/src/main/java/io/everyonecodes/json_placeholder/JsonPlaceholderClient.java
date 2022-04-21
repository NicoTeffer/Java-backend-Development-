package io.everyonecodes.json_placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Controller
public class JsonPlaceholderClient {

    private final RestTemplate restTemplate;
    private final PostTranslator postTranslator;
    private final String url;

    public JsonPlaceholderClient(
            RestTemplate restTemplate,
            PostTranslator postTranslator,
            @Value("${jsonplaceholder.posts.url}") String url
    ) {
        this.restTemplate = restTemplate;
        this.postTranslator = postTranslator;
        this.url = url;
    }

    public List<Post> getAll() {
        PostDTO[] dtos = restTemplate.getForObject(url, PostDTO[].class);
        return Stream.of(dtos)
                .map(postTranslator::translateToPost)
                .collect(toList());
    }

    public Post getOne(int id) {
        PostDTO dto = restTemplate.getForObject(url + "/" + id, PostDTO.class);
        // assert dto != null;
        return postTranslator.translateToPost(dto);
    }

    public Post post(Post post) {
        PostDTO requestDTO = postTranslator.translateToDTO(post);
        PostDTO responseDTO = restTemplate.postForObject(url, requestDTO, PostDTO.class);
        // assert responseDTO != null;
        return postTranslator.translateToPost(responseDTO);
    }

    public Post put(int id, Post post) {
        PostDTO requestDTO = postTranslator.translateToDTO(post);
        restTemplate.put(url + "/" + id, requestDTO);
        return post;
    }

    public void delete() {
        restTemplate.delete(url);
    }

    public void delete(int id) {
        restTemplate.delete(url + "/" + id);
    }
}
