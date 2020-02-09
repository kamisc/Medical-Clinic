package com.doctor.domain.exception;

/**
 * Author Kamil Seweryn
 */

public class DoctorNotExistException extends Exception {
    public DoctorNotExistException() {
        super("This doctor dosen't exist in the database!");
    }

    public DoctorNotExistException(String surname) {
        super("Doctor with surname: " + surname + " dosen't exist in the database!");
    }
}