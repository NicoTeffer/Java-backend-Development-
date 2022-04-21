package io.everyonecodes.json_placeholder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PostTranslatorTest {
    PostTranslator postTranslator = new PostTranslator();

    Post post = new Post("title", "content", 1, 2);

    PostDTO postDTO = new PostDTO(2, 1, "title", "content");

    @Test
    void translateToDTO() {
        PostDTO result = postTranslator.translateToDTO(post);

        Assertions.assertEquals(postDTO, result);
    }

    @Test
    void translateToPost() {
        Post result = postTranslator.translateToPost(postDTO);

        Assertions.assertEquals(post, result);
    }
}