package com.doctor.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author Kamil Seweryn
 */

@RestControllerAdvice
public class SpecializationNotExistAdvice {

    @ExceptionHandler(SpecializationNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String specializationNotExistHandler(SpecializationNotExistException ex) {
        return ex.getMessage();
    }
}