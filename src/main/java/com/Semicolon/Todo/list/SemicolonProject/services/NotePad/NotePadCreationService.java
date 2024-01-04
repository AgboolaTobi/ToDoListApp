package com.Semicolon.Todo.list.SemicolonProject.services.NotePad;

import com.Semicolon.Todo.list.SemicolonProject.data.models.NotePad;
import com.Semicolon.Todo.list.SemicolonProject.data.models.User;
import com.Semicolon.Todo.list.SemicolonProject.dtos.requests.NotePadCreationRequest;

import com.Semicolon.Todo.list.SemicolonProject.exceptions.NotePadCreationException;
import com.Semicolon.Todo.list.SemicolonProject.services.authenticateRegistration.UserService;
import com.Semicolon.Todo.list.SemicolonProject.utils.ApiResponse;
import com.Semicolon.Todo.list.SemicolonProject.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotePadCreationService {

    private final UserService userService;
    private final NotePadService notePadService;

    public ApiResponse createNotePad(NotePadCreationRequest notePadCreationRequest) throws NotePadCreationException {


        User user = userService.findUserByEmailAddress(notePadCreationRequest.getUserEmailAddress());
        if (user==null) throw new NotePadCreationException(GenerateApiResponse.USER_NOT_FOUND);

        NotePad existingNotePad = notePadService.findByNotePadName(notePadCreationRequest.getNotePadName());

        if (existingNotePad!=null) throw new NotePadCreationException(GenerateApiResponse.NOTEPAD_WITH_THIS_NAME_ALREADY_EXIST);

        NotePad notePad = new NotePad();
        notePad.setNotePadName(notePadCreationRequest.getNotePadName());

        existingNotePad = notePadService.save(notePad);

        user.setNotePad(existingNotePad);
        userService.save(user);


        return GenerateApiResponse.created(GenerateApiResponse.NOTEPAD_SUCCESSFULLY_CREATED);

    }
}
