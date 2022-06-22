package io.everyonecodes.steam_users;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @MockBean
    PasswordEncoder passwordEncoder;

    @MockBean
    SecurityFilterChain securityFilterChain;

    @Value("${user-credentials.authorities}")
    Set<String> authorities;


    @Test
    void postUser() {
        User user = new User("test", "test");
        Mockito.when(userRepository.findOneByUsername(user.getUsername())).thenReturn(Optional.empty());

        userService.postUser(user);

        Mockito.verify(userRepository).findOneByUsername("test");
        Mockito.verify(userRepository).save(user);
    }

    @Test
    void postUserIsAlreadyFound() {
        User user = new User("test", "test");
        Mockito.when(userRepository.findOneByUsername(user.getUsername())).thenReturn(Optional.of(user));

        userService.postUser(user);

        Mockito.verify(userRepository).findOneByUsername("test");
    }

    @Test
    void findOneBy() {
        String username = "user";

        userService.findOneBy(username);

        Mockito.verify(userRepository).findOneByUsername(username);
    }

    @Test
    void postLoginSuccess() {
        User user = new User("test", "test");
        Mockito.when(userRepository.findOneByUsername(user.getUsername())).thenReturn(Optional.of(user));

        userService.postLogin(user);

        Mockito.verify(userRepository).findOneByUsername(user.getUsername());
    }

    @Test
    void postLoginNoSuccess() {
        User user = new User("test", "test");
        Mockito.when(userRepository.findOneByUsername(user.getUsername())).thenReturn(Optional.empty());

        userService.postLogin(user);

        Mockito.verify(userRepository).findOneByUsername(user.getUsername());
    }
}