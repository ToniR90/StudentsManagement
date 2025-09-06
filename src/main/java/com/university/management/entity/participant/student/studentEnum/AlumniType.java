package com.university.management.entity.participant.student.studentEnum;

import com.university.management.exception.personalException.InvalidAlumniTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlumniType {
    PRE_JUNIOR("Pre-junior alumni") ,
    JUNIOR("Junior alumni") ,
    ALUMNI("Alumni alumni") ,
    SENIOR("Senior alumni");

    private final String label;

    public static AlumniType fromLabel(String label) {
        if(label == null || label.trim().isEmpty()) {
            throw new InvalidAlumniTypeException("null or empty");
        }
        for(AlumniType status : values()) {
            if(status.label.equalsIgnoreCase(label)) {
                return status;
            }
        }
        throw new InvalidAlumniTypeException(label);
    }
}