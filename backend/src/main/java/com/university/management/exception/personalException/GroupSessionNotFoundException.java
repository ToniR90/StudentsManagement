package com.university.management.exception.personalException;

public class GroupSessionNotFoundException extends RuntimeException {
    public GroupSessionNotFoundException(String message) {
        super("Group Session not found");
    }
}
