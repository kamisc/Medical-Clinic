package com.doctor.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author Kamil Seweryn
 */

@RestControllerAdvice
public class CantDeleteSpecializationAdvice {
    @ExceptionHandler(CantDeleteSpecializationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String cantDeleteSpecializationHandler(CantDeleteSpecializationException ex) {
        return ex.getMessage();
    }
}