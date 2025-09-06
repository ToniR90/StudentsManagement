package com.university.management.exception.personalException;

public class ExternalCollaboratorNotFoundException extends RuntimeException {
    public ExternalCollaboratorNotFoundException(String message) {
        super("External Collaborator not found");
    }
}
