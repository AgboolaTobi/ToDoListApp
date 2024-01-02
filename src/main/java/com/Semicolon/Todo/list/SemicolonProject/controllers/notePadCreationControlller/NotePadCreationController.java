package com.Semicolon.Todo.list.SemicolonProject.controllers.notePadCreationControlller;

import com.Semicolon.Todo.list.SemicolonProject.dtos.requests.NotePadCreationRequest;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.NotePadCreationException;
import com.Semicolon.Todo.list.SemicolonProject.services.NotePad.NotePadCreationService;
import com.Semicolon.Todo.list.SemicolonProject.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/toDoApp/")
@CrossOrigin(origins = "*")
@AllArgsConstructor

public class NotePadCreationController {

    NotePadCreationService notePadCreationService;

    @PostMapping("createNotePad")

    public ResponseEntity<ApiResponse> createNotePad(@RequestBody NotePadCreationRequest notePadCreationRequest) throws NotePadCreationException {
        return new ResponseEntity<>(notePadCreationService.createNotePad(notePadCreationRequest),HttpStatus.CREATED);
    }
}
