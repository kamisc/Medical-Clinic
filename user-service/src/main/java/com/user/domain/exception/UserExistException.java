package com.user.domain.exception;

/**
 * Author Kamil Seweryn
 */

public class UserExistException extends Exception {
    public UserExistException(String email) {
        super("User with e-mail: " + email + " already exist in the database!");
    }
}