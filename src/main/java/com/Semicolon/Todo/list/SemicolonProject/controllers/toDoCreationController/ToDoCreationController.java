package com.Semicolon.Todo.list.SemicolonProject.controllers.toDoCreationController;

import com.Semicolon.Todo.list.SemicolonProject.dtos.requests.ToDoCreationRequest;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.ToDoCreationException;
import com.Semicolon.Todo.list.SemicolonProject.services.toDoTask.ToDoCreationService;
import com.Semicolon.Todo.list.SemicolonProject.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/toDoApp/")
@CrossOrigin(origins = "*")
@AllArgsConstructor

public class ToDoCreationController {

    private final ToDoCreationService toDoCreationService;
    @PostMapping("createToDo")
    public ResponseEntity<ApiResponse> createTodo(@RequestBody ToDoCreationRequest toDoCreationRequest) throws ToDoCreationException {
        return new ResponseEntity<>(toDoCreationService.createToDoTask(toDoCreationRequest), HttpStatus.CREATED);
    }
}
