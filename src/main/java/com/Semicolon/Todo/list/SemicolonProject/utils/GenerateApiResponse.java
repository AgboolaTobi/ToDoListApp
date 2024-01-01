package com.Semicolon.Todo.list.SemicolonProject.utils;

import org.springframework.http.HttpStatus;

public class GenerateApiResponse {

    public static final String USER_ALREADY_EXIST = "The registration details submitted have already been taken.";
    public static final String ACCOUNT_SUCCESSFULLY_CREATED = "Account successfully created";

    public static ApiResponse created(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .isSuccessful(true)
                .build();
    }
}
