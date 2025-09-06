package com.university.management.exception.personalException;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super("Student not found");
    }
}
