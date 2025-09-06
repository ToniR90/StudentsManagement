package com.university.management.exception.personalException;

public class ParticipantNotFoundException extends RuntimeException {
    public ParticipantNotFoundException(String message) {
        super("Participant not found");
    }
}
