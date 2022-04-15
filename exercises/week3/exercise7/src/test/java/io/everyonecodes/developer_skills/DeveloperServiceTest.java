package io.everyonecodes.developer_skills;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeveloperServiceTest {

    @Autowired
    DeveloperService developerService;

    @Test
    void findAll() {
        var result = developerService.findAll().size();
        var expected = result==4;
        Assertions.assertTrue(expected);
    }

    @Test
    void findBy() {
        var result = developerService.findBy("A B").size();
        var expected = result==1;
        Assertions.assertTrue(expected);
    }
}