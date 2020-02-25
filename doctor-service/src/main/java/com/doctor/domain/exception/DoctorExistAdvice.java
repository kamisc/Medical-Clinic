package com.doctor.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author Kamil Seweryn
 */

@RestControllerAdvice
public class DoctorExistAdvice {
    @ExceptionHandler(DoctorExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String doctorExistHandler(DoctorExistException ex) {
        return ex.getMessage();
    }
}