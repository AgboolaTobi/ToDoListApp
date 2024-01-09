package com.Semicolon.Todo.list.SemicolonProject.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRemoveToDoRequest {
    private String emailAddress;
    private String title;
}
