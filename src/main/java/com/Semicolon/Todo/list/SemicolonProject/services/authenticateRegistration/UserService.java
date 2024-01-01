package com.Semicolon.Todo.list.SemicolonProject.services.authenticateRegistration;

import com.Semicolon.Todo.list.SemicolonProject.data.models.User;

public interface UserService {
    User save(User user);

    User findUserByEmailAddress(String emailAddress);
}
