package com.doctor.domain.exception;

/**
 * Author Kamil Seweryn
 */

public class SpecializationNotExistException extends Exception {

    public SpecializationNotExistException() {
        super("This specialization doesn't exist in the database!");
    }
}