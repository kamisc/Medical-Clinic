package com.visit.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author Kamil Seweryn
 */

@RestControllerAdvice
public class VisitNotExistAdvice {
    @ExceptionHandler(VisitNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String visitNotExistHandler(VisitNotExistException ex) {
        return ex.getMessage();
    }
}