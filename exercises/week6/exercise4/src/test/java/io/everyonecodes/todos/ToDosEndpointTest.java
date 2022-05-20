package io.everyonecodes.todos;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDosEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    ToDoManager toDoManager;

    @Test
    void getTodos() {
        String url = "/todos";
        ToDo toDo = new ToDo("Test", false);
        Mockito.when(toDoManager.getTodoList()).thenReturn(List.of(toDo));

        testRestTemplate.getForObject(url, ToDo[].class);

        Mockito.verify(toDoManager).getTodoList();
    }

    @Test
    void getTodoByID() {
        String url = "/todos";
        String id = "test";
        Optional<ToDo> toDo = Optional.of(new ToDo(id, "Test", false));
        Mockito.when(toDoManager.getTodoById(id)).thenReturn(toDo);

        testRestTemplate.getForObject(url + "/" + id, Optional.class);

        Mockito.verify(toDoManager).getTodoById(id);
    }

    @Test
    void post() {
        String url = "/todos";
        String id = "test";
        ToDo toDo = new ToDo(id, "Test", false);

        testRestTemplate.postForObject(url, toDo, Void.class);

        Mockito.verify(toDoManager).postTodo(toDo);
    }

    @Test
    void put() {
        String url = "/todos";
        String id = "test";
        ToDo toDo = new ToDo(id, "Test", false);

        testRestTemplate.put(url + "/" + id + "/done", id, Void.class);

        Mockito.verify(toDoManager).markTodoAsDone(id);
    }

    @Test
    void deleteById() {
        String url = "/todos";
        String id = "test";
        ToDo toDo = new ToDo(id, "Test", false);

        testRestTemplate.delete(url + "/" + id, Void.class);

        Mockito.verify(toDoManager).deleteTodo(id);
    }
}