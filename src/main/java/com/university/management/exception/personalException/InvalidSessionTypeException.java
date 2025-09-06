package com.university.management.exception.personalException;

public class InvalidSessionTypeException extends RuntimeException {
    public InvalidSessionTypeException(String label) {
        super("Invalid Session Type: " + label);
    }
}
