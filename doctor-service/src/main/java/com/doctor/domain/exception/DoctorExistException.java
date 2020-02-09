package com.doctor.domain.exception;

/**
 * Author Kamil Seweryn
 */

public class DoctorExistException extends Exception {
    public DoctorExistException(String surname) {
        super("Doctor with surname: " + surname + " already exist in the database!");
    }
}