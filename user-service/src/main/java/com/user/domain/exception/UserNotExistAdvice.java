package com.user.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author Kamil Seweryn
 */

@RestControllerAdvice
public class UserNotExistAdvice {
    @ExceptionHandler(UserNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotExistHandler(UserNotExistException ex) {
        return ex.getMessage();
    }
}