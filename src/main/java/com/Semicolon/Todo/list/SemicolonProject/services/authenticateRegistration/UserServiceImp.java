package com.Semicolon.Todo.list.SemicolonProject.services.authenticateRegistration;

import com.Semicolon.Todo.list.SemicolonProject.data.models.User;
import com.Semicolon.Todo.list.SemicolonProject.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmailAddress(String emailAddress) {
        return userRepository.findUserByEmailAddress(emailAddress);
    }
}
