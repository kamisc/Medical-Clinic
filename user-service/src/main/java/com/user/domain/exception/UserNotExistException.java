package com.user.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author Kamil Seweryn
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This user dosen't exist in the database!")
public class UserNotExistException extends Exception {
    public UserNotExistException() {
        super("This dosen't exist in the database!");
    }

    public UserNotExistException(String email) {
        super("User with e-mail: " + email + " dosen't exist in the database!");
    }
}