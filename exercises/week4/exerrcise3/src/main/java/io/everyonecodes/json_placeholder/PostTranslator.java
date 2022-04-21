package io.everyonecodes.json_placeholder;

import org.springframework.stereotype.Controller;

@Service
public class PostTranslator {

    public PostDTO translateToDTO(Post post) {
        return new PostDTO(
                post.getIdentifier(),
                post.getUser(),
                post.getTitle(),
                post.getContent()
        );
    }

    public Post translateToPost(PostDTO postDTO) {
        return new Post(
                postDTO.getTitle(),
                postDTO.getBody(),
                postDTO.getUserId(),
                postDTO.getId()
        );
    }
}
