package com.Semicolon.Todo.list.SemicolonProject.controllers.toDoCreationController;

import com.Semicolon.Todo.list.SemicolonProject.data.models.ToDoTask;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.ToDoCreationException;
import com.Semicolon.Todo.list.SemicolonProject.services.toDoTask.GetAUserListOfToDo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/toDoApp/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class GetAllToDoController {

    private final GetAUserListOfToDo getAUserListOfToDo;

    @GetMapping("getAllToDos")
    public ResponseEntity<List<ToDoTask>> getAUserListOfToDo(@RequestParam String emailAddress) throws ToDoCreationException {
        return new ResponseEntity<>(getAUserListOfToDo.getUserListOfToDo(emailAddress), HttpStatus.OK);
    }
}
