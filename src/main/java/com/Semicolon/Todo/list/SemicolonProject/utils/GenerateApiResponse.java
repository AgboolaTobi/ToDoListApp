package com.Semicolon.Todo.list.SemicolonProject.utils;

import org.springframework.http.HttpStatus;

public class GenerateApiResponse {

    public static final String USER_ALREADY_EXIST = "The registration details submitted have already been taken.";
    public static final String ACCOUNT_SUCCESSFULLY_CREATED = "Account successfully created";
    public static final String NOTEPAD_SUCCESSFULLY_CREATED = "Notepad successfully created";
    public static final String USER_NOT_FOUND = "User not yet registered";
    public static final String NOTEPAD_WITH_THIS_NAME_ALREADY_EXIST = "Notepad name is already taken. Kindly use a different one";
    public static final String USER_DOES_NOT_HAVE_A_NOTEPAD_YET = "User does not have a notepad yet";
    public static final String TO_DO_SUCCESSFULLY_ADDED = "You have successfully added to your ToDo";
    public static final String NOTE_NAME_NOT_FOUND = "Notepad with this name note found";
    public static final String NO_TODO_FOUND_FOR_USER = "This user does not have any ToDo at the moment.";
    public static final String NO_NOTEPAD_FOUND_FOR_USER = "No notepad found for this user";
    public static final String TODO_SUCCESSFULLY_REMOVED = "ToDo task successfully removed";

    public static ApiResponse created(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .isSuccessful(true)
                .build();
    }

    public static ApiResponse removed(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .isSuccessful(true)
                .build();
    }
}
