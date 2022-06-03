package io.everyonecodes.todos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoManager {

    private final ToDoRepository toDoRepository;

    public ToDoManager(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    //TODO: GET to “/todos” -> returns a list of all the saved ToDos.
    public List<ToDo> getTodoList() {
        return toDoRepository.findAll();
    }

    //TODO: GET to “/todos/{id}” -> returns the ToDo that matches that id.
    public Optional<ToDo> getTodoById(String id) {
        return toDoRepository.findById(id);
    }

    //TODO: POST a ToDo to “/todos” -> saves a new ToDo and returns it.
    public ToDo postTodo(ToDo toDo) {
        System.out.println("Todo has been saved!");
        return toDoRepository.save(toDo);
    }

    //TODO: PUT to “/todos/{id}/done” -> marks the ToDo with the matching id as done
    // and returns it, if it exists.
    public Optional<ToDo> markTodoAsDone(String id) {
        Optional<ToDo> optionalToDo = toDoRepository.findById(id);
        if (optionalToDo.isEmpty()) {
            return Optional.empty();
        }
        ToDo toDo = optionalToDo.get();
        toDo.setDone(true);
        toDoRepository.save(toDo);
        System.out.println("Todo has been marked as 'done'!");
        return Optional.of(toDo);
    }

    //TODO: DELETE to “/todos/{id}” -> deletes the ToDo that matches that id.
    public void deleteTodo(String id) {
        if (ifExists(id)) {
            toDoRepository.deleteById(id);
        }
        System.out.println("Todo has been deleted!");
    }

    private boolean ifExists(String id) {
        return getTodoById(id).isPresent();
    }
}
