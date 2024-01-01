package com.Semicolon.Todo.list.SemicolonProject.data.repositories;

import com.Semicolon.Todo.list.SemicolonProject.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    User findUserByEmailAddress(String emailAddress);
}
