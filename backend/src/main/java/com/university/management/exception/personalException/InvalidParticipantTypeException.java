package com.university.management.exception.personalException;

public class InvalidParticipantTypeException extends RuntimeException {
    public InvalidParticipantTypeException(String message) {
        super("Invalid Participant Type");
    }
}
