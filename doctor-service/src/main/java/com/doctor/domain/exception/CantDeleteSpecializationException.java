package com.doctor.domain.exception;

/**
 * Author Kamil Seweryn
 */

public class CantDeleteSpecializationException extends Exception {
    public CantDeleteSpecializationException(String name) {
        super("The specialization: " + name + " cannot be removed because at least ond doctor has it!");
    }
}