package com.visit.domain.exception;

/**
 * Author Kamil Seweryn
 */

public class VisitExistException extends Exception {
    public VisitExistException() {
        super("That visit doesn't exist!");
    }
}