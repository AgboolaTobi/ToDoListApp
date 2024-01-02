package com.Semicolon.Todo.list.SemicolonProject.services.toDoTask;

import com.Semicolon.Todo.list.SemicolonProject.data.models.NotePad;
import com.Semicolon.Todo.list.SemicolonProject.data.models.User;
import com.Semicolon.Todo.list.SemicolonProject.dtos.requests.ToDoCreationRequest;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.ToDoCreationException;
import com.Semicolon.Todo.list.SemicolonProject.services.NotePad.NotePadService;
import com.Semicolon.Todo.list.SemicolonProject.services.authenticateRegistration.UserService;
import com.Semicolon.Todo.list.SemicolonProject.utils.ApiResponse;
import com.Semicolon.Todo.list.SemicolonProject.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ToDoCreationService {

    private final UserService userService;
    private final NotePadService notePadService;
    private final ToDoTaskService toDoTaskService;


    public ApiResponse createToDoTask(ToDoCreationRequest toDoCreationRequent) throws ToDoCreationException {
        User user = userService.findUserByEmailAddress(toDoCreationRequent.getUserEmailAddress());

        if (user == null) throw new ToDoCreationException(GenerateApiResponse.USER_NOT_FOUND);
        NotePad notePad = notePadService.findByNotePadName(toDoCreationRequent.getNotePadName());

        return null;
    }
}
