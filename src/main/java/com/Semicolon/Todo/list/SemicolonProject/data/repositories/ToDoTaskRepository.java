package com.Semicolon.Todo.list.SemicolonProject.data.repositories;

import com.Semicolon.Todo.list.SemicolonProject.data.models.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoTaskRepository extends JpaRepository<ToDoTask, Long> {
}
