package io.everyonecodes.todos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ToDosEndpoint {

    private final ToDoManager toDoManager;

    public ToDosEndpoint(ToDoManager toDoManager) {
        this.toDoManager = toDoManager;
    }

    //TODO: GET to “/todos” -> returns a list of all the saved ToDos.
    @GetMapping("/todos")
    List<ToDo> getTodos() {
        return toDoManager.getTodoList();
    }

    //TODO: GET to “/todos/{id}” -> returns the ToDo that matches that id.
    @GetMapping("/todos/{id}")
    ToDo getTodoByID(@PathVariable String id) {
        return toDoManager.getTodoById(id).orElse(null);
    }

    //TODO: POST a ToDo to “/todos” -> saves a new ToDo and returns it.
    @PostMapping("/todos")
    ToDo post(@RequestBody ToDo toDo) {
        return toDoManager.postTodo(toDo);
    }

    //TODO: PUT to “/todos/{id}/done” -> marks the ToDo with the matching id as done and returns it, if it exists.
    @PutMapping("/todos/{id}/done")
    void put(@PathVariable String id) {
        toDoManager.markTodoAsDone(id);
    }

    //TODO: DELETE to “/todos/{id}” -> deletes the ToDo that matches that id.
    @DeleteMapping("/todos/{id}")
    void deleteById(@PathVariable String id) {
        toDoManager.deleteTodo(id);
    }
}
