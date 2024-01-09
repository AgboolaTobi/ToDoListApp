package com.Semicolon.Todo.list.SemicolonProject.services.authenticateRegistration;

import com.Semicolon.Todo.list.SemicolonProject.data.models.NotePad;
import com.Semicolon.Todo.list.SemicolonProject.data.models.ToDoTask;
import com.Semicolon.Todo.list.SemicolonProject.data.models.User;
import com.Semicolon.Todo.list.SemicolonProject.dtos.requests.UserRemoveToDoRequest;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.NotePadCreationException;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.RegistrationException;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.ToDoCreationException;
import com.Semicolon.Todo.list.SemicolonProject.services.NotePad.NotePadService;
import com.Semicolon.Todo.list.SemicolonProject.services.toDoTask.ToDoTaskService;
import com.Semicolon.Todo.list.SemicolonProject.utils.ApiResponse;
import com.Semicolon.Todo.list.SemicolonProject.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserToRemoveToDoService {
    private final UserService userService;
    private final NotePadService notePadService;
    private final ToDoTaskService toDoTaskService;

    public ApiResponse removeToDoTask(UserRemoveToDoRequest userRemoveToDoRequest) throws RegistrationException, NotePadCreationException, ToDoCreationException {

        User user = userService.findUserByEmailAddress(userRemoveToDoRequest.getEmailAddress());
        if (user==null) throw new RegistrationException(GenerateApiResponse.USER_NOT_FOUND);
        NotePad userNotePad = user.getNotePad();
        if (userNotePad == null) throw new NotePadCreationException(GenerateApiResponse.NO_NOTEPAD_FOUND_FOR_USER);

        ToDoTask toDoTaskOfUser = toDoTaskService.findByTitle(userRemoveToDoRequest.getTitle());

        if (toDoTaskOfUser ==null) throw new ToDoCreationException(GenerateApiResponse.NO_TODO_FOUND_FOR_USER);
        List<ToDoTask> listOfUserToDo = userNotePad.getTasks();
        listOfUserToDo.remove(toDoTaskOfUser);
        userNotePad.setTasks(new ArrayList<>(listOfUserToDo));

        NotePad updatedNotePad = notePadService.save(userNotePad);
        user.setNotePad(updatedNotePad);
        userService.save(user);

        return GenerateApiResponse.removed(GenerateApiResponse.TODO_SUCCESSFULLY_REMOVED);


    }

}
