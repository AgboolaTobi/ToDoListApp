package com.Semicolon.Todo.list.SemicolonProject.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDoCreationRequest {
    private String userEmailAddress;
    private String userNotePadName;
    private String toDoTitle;
    private String toDoBody;
    private LocalDateTime createdAt;


}
