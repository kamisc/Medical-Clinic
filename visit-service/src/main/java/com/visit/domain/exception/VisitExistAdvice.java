package com.visit.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author Kamil Seweryn
 */

@RestControllerAdvice
public class VisitExistAdvice {
    @ExceptionHandler(VisitExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String visitExistHandler(VisitExistException ex) {
        return ex.getMessage();
    }
}