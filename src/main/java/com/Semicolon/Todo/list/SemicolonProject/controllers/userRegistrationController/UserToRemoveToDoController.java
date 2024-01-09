package com.Semicolon.Todo.list.SemicolonProject.controllers.userRegistrationController;

import com.Semicolon.Todo.list.SemicolonProject.dtos.requests.UserRemoveToDoRequest;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.NotePadCreationException;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.RegistrationException;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.ToDoCreationException;
import com.Semicolon.Todo.list.SemicolonProject.services.authenticateRegistration.UserToRemoveToDoService;
import com.Semicolon.Todo.list.SemicolonProject.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/toDoApp/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserToRemoveToDoController {

    private final UserToRemoveToDoService userToRemoveToDoService;

    @PostMapping("removeToDoTask")
    public ResponseEntity<ApiResponse> removeToDoTask(@RequestBody UserRemoveToDoRequest userRemoveToDoRequest) throws RegistrationException, ToDoCreationException, NotePadCreationException {
        return new ResponseEntity<>(userToRemoveToDoService.removeToDoTask(userRemoveToDoRequest), HttpStatus.OK);

    }
}
