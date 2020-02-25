package com.doctor.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author Kamil Seweryn
 */

@RestControllerAdvice
public class DoctorNotExistAdvice {
    @ExceptionHandler(DoctorNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String doctorNotExistHandler(DoctorNotExistException ex) {
        return ex.getMessage();
    }
}