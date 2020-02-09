package com.doctor.domain.exception;

/**
 * Author Kamil Seweryn
 */

public class SpecializationExistException extends Exception {
    public SpecializationExistException(String name) {
        super("Specialization with name: " + name + " already exist in the database!");
    }
}
