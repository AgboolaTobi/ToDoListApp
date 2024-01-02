package com.Semicolon.Todo.list.SemicolonProject.exceptions;

import com.Semicolon.Todo.list.SemicolonProject.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<ApiResponse> registrationException(RegistrationException registrationException) {
        ApiResponse apiResponse = ApiResponse.builder()
                .data(registrationException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NotePadCreationException.class)
    public ResponseEntity<ApiResponse> NotePadCreationException(NotePadCreationException notePadCreationException) {
        ApiResponse apiResponse = ApiResponse.builder()
                .data(notePadCreationException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);

    }
}
