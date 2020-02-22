package com.visit.domain.exception;

/**
 * Author Kamil Seweryn
 */

public class VisitNotExistException extends Exception {
    public VisitNotExistException() {
        super("This visit doesn't exist!");
    }
}