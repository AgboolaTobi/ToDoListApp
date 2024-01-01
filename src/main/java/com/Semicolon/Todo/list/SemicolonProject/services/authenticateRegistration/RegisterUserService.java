package com.Semicolon.Todo.list.SemicolonProject.services.authenticateRegistration;

import com.Semicolon.Todo.list.SemicolonProject.data.models.User;
import com.Semicolon.Todo.list.SemicolonProject.dtos.requests.RegistrationRequest;
import com.Semicolon.Todo.list.SemicolonProject.exceptions.RegistrationException;
import com.Semicolon.Todo.list.SemicolonProject.utils.ApiResponse;
import com.Semicolon.Todo.list.SemicolonProject.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterUserService {

    private final UserService userService;

    private final ModelMapper modelMapper;


    public ApiResponse register(RegistrationRequest registrationRequest) throws RegistrationException {

        boolean isRegistered = userService.findUserByEmailAddress(registrationRequest.getEmailAddress())!= null;

        if (isRegistered) throw new RegistrationException(GenerateApiResponse.USER_ALREADY_EXIST);

        User user = modelMapper.map(registrationRequest, User.class);

        userService.save(user);

        return GenerateApiResponse.created(GenerateApiResponse.ACCOUNT_SUCCESSFULLY_CREATED);


    }
}
