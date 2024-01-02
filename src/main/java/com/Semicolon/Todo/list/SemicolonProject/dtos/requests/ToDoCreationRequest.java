package com.Semicolon.Todo.list.SemicolonProject.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDoCreationRequest {
    private String userEmailAddress;
    private String notePadName;
    private String password;
}
