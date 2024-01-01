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
public class RegistrationRequest {
    private String userName;
    private String emailAddress;
    private String phoneNumber;
    private LocalDateTime createdAt=LocalDateTime.now();
}
