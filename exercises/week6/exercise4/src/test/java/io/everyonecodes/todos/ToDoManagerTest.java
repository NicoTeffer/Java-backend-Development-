package io.everyonecodes.todos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager toDoManager;

    @MockBean
    ToDoRepository toDoRepository;

    @Test
    void getTodoList() {
        ToDo toDo = new ToDo("Test", false);
        Mockito.when(toDoRepository.findAll()).thenReturn(List.of(toDo));

        var response = toDoManager.getTodoList();
        var expected = List.of(toDo);

        Mockito.verify(toDoRepository).findAll();
        Assertions.assertEquals(expected, response);
    }

    @Test
    void getTodoById() {
        String id = "test";
        Optional<ToDo> toDo = Optional.of(new ToDo(id, "Test", false));
        Mockito.when(toDoRepository.findById(id)).thenReturn(toDo);

        var response = toDoManager.getTodoById(id);

        Mockito.verify(toDoRepository).findById(id);
        Assertions.assertEquals(toDo, response);
    }

    @Test
    void postTodo() {
        String id = "test";
        String title = "this is a test";
        ToDo toDo = new ToDo(id, title, false);
        Mockito.when(toDoRepository.save(toDo)).thenReturn(toDo);

        toDoManager.postTodo(toDo);

        Mockito.verify(toDoRepository).save(toDo);
    }

    @Test
    void markTodoAsDone() {
        String id = "test";
        ToDo toDoOpen = new ToDo(id, "Test", false);
        ToDo toDoDone = new ToDo(id, "Test", true);
        Mockito.when(toDoRepository.findById(id)).thenReturn(Optional.of(toDoOpen));

        toDoManager.markTodoAsDone(id);
        var result = toDoManager.getTodoById(id);
        var expected = Optional.of(toDoDone);

        Mockito.verify(toDoRepository, Mockito.times(3)).findById(id);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void deleteTodo() {
        String id = "test";
        ToDo toDo = new ToDo(id, "Test", false);
        var x = List.of(toDo);
        Mockito.when(toDoRepository.findById(id)).thenReturn(Optional.of(toDo));

        toDoManager.deleteTodo(id);

        Mockito.verify(toDoRepository).deleteById(id);
        Mockito.verify(toDoRepository).findById(id);
    }
}