package com.doctor.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author Kamil Seweryn
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This doctor dosen't exist in the database!")
public class DoctorNotExistException extends Exception {
    public DoctorNotExistException() {
        super("This doctor dosen't exist in the database!");
    }
}