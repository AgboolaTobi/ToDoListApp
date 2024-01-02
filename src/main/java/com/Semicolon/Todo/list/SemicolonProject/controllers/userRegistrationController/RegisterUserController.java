package com.Semicolon.Todo.list.SemicolonProject.controllers.userRegistrationController;

import com.Semicolon.Todo.list.SemicolonProject.dtos.requests.RegistrationRequest;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.RegistrationException;
import com.Semicolon.Todo.list.SemicolonProject.services.authenticateRegistration.RegisterUserService;
import com.Semicolon.Todo.list.SemicolonProject.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/toDoApp/")
@CrossOrigin(origins = "*")
@AllArgsConstructor

public class RegisterUserController {

    private final RegisterUserService registerUserService;


    @PostMapping("register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest registrationRequest) throws RegistrationException {

        return new ResponseEntity<>(registerUserService.register(registrationRequest), HttpStatus.CREATED);
    }

}
