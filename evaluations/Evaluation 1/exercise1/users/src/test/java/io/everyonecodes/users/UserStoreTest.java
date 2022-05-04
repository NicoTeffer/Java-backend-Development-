package io.everyonecodes.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserStoreTest {

    @Autowired
    UserStore userStore;

    @Test
    void getUser_returnsAllKnownUsers() {
        User a = new User("test1","test1mail","normal");
        User b = new User("test2","test2mail","normal");
        User c = new User("test3","test3mail","premium");
        User d = new User("test4","test4mail","premium");
        List<User> expected = List.of(a,b,c,d);
        var result = userStore.getUserList();
        Assertions.assertEquals(expected,result);
    }

    @Test
    void getUser_returnsNullForUnknown() {
        var result = userStore.getUser("test5mail");
        Assertions.assertNull(result);
    }
}