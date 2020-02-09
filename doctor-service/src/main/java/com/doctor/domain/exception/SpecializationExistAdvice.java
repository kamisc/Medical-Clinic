package com.doctor.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author Kamil Seweryn
 */

@RestControllerAdvice
public class SpecializationExistAdvice {

    @ExceptionHandler(SpecializationExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String specializationExistHandler(SpecializationExistException ex) {
        return ex.getMessage();
    }
}