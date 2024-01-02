package com.Semicolon.Todo.list.SemicolonProject.services.toDoTask;

import com.Semicolon.Todo.list.SemicolonProject.data.models.ToDoTask;
import com.Semicolon.Todo.list.SemicolonProject.data.repositories.ToDoTaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ToDoServiceImp implements ToDoTaskService{

    private final ToDoTaskRepository toDoTaskRepository;
    @Override
    public ToDoTask save(ToDoTask toDoTask) {
        return toDoTaskRepository.save(toDoTask);
    }
}
