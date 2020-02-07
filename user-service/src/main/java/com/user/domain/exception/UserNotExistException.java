package com.user.domain.exception;

/**
 * Author Kamil Seweryn
 */

public class UserNotExistException extends Exception {
    public UserNotExistException() {
        super("This dosen't exist in the database!");
    }

    public UserNotExistException(String email) {
        super("User with e-mail: " + email + " dosen't exist in the database!");
    }
}