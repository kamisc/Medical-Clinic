package com.doctor.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author Kamil Seweryn
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This doctor exist in the database!")
public class DoctorExistException extends Exception {
    public DoctorExistException() {
        super("This doctor exist in the database!");
    }
}