package com.university.management.exception.personalException;

public class IndividualSessionNotFoundException extends RuntimeException {
    public IndividualSessionNotFoundException(String message) {
        super("Individual Session not found");
    }
}
