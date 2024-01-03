package com.Semicolon.Todo.list.SemicolonProject.services.toDoTask;

import com.Semicolon.Todo.list.SemicolonProject.data.models.NotePad;
import com.Semicolon.Todo.list.SemicolonProject.data.models.ToDoTask;
import com.Semicolon.Todo.list.SemicolonProject.data.models.User;
import com.Semicolon.Todo.list.SemicolonProject.dtos.requests.ToDoCreationRequest;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.ToDoCreationException;
import com.Semicolon.Todo.list.SemicolonProject.services.NotePad.NotePadService;
import com.Semicolon.Todo.list.SemicolonProject.services.authenticateRegistration.UserService;
import com.Semicolon.Todo.list.SemicolonProject.utils.ApiResponse;
import com.Semicolon.Todo.list.SemicolonProject.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ToDoCreationService {

    private final UserService userService;
    private final NotePadService notePadService;
    private final ToDoTaskService toDoTaskService;


    public ApiResponse createToDoTask(ToDoCreationRequest toDoCreationRequest) throws ToDoCreationException {
        User user = userService.findUserByEmailAddress(toDoCreationRequest.getUserEmailAddress());

        if (user == null) throw new ToDoCreationException(GenerateApiResponse.USER_NOT_FOUND);

        NotePad notePad = user.getNotePad();
        if (notePad==null) throw new ToDoCreationException(GenerateApiResponse.USER_DOES_NOT_HAVE_A_NOTEPAD_YET);
        String savedNotePad = notePad.getNotePadName();
        if (savedNotePad==null) throw new ToDoCreationException(GenerateApiResponse.NOTE_NAME_NOT_FOUND);
        ToDoTask toDoTask = new ToDoTask();

        toDoTask.setTitle(toDoCreationRequest.getToDoTitle());
        toDoTask.setBody(toDoCreationRequest.getToDoBody());
        toDoTask.setCreatedAt(LocalDateTime.now());

        ToDoTask savedToDos = toDoTaskService.save(toDoTask);

        List<ToDoTask> listOfToDos = notePad.getTasks();

        listOfToDos.add(savedToDos);

        notePad.setTasks(new ArrayList<>(listOfToDos));
        NotePad updatedNotePad = notePadService.save(notePad);

        user.setNotePad(updatedNotePad);

        userService.save(user);

        return GenerateApiResponse.created(GenerateApiResponse.TO_DO_SUCCESSFULLY_ADDED);
    }
}
