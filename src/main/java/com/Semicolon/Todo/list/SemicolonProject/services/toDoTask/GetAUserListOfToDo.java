package com.Semicolon.Todo.list.SemicolonProject.services.toDoTask;

import com.Semicolon.Todo.list.SemicolonProject.data.models.NotePad;
import com.Semicolon.Todo.list.SemicolonProject.data.models.ToDoTask;
import com.Semicolon.Todo.list.SemicolonProject.data.models.User;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.ToDoCreationException;
import com.Semicolon.Todo.list.SemicolonProject.services.authenticateRegistration.UserService;
import com.Semicolon.Todo.list.SemicolonProject.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAUserListOfToDo {

    private final UserService userService;

    public List<ToDoTask> getUserListOfToDo(String emailAddress) throws ToDoCreationException {

        User user = userService.findUserByEmailAddress(emailAddress);
        if (user==null) throw new ToDoCreationException(GenerateApiResponse.NO_TODO_FOUND_FOR_USER);

        NotePad userNotePad = user.getNotePad();

        if (userNotePad==null) throw new ToDoCreationException(GenerateApiResponse.NO_NOTEPAD_FOUND_FOR_USER);

        return userNotePad.getTasks();
    }
}
