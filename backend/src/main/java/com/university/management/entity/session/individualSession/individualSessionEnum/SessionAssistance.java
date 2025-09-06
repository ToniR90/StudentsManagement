package com.university.management.entity.session.individualSession.individualSessionEnum;

import com.university.management.exception.personalException.InvalidSessionAssistanceException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SessionAssistance {
    YES("Yes") ,
    NO("No") ,
    NO_ADVICE("No, but notified");

    private final String label;

    public static SessionAssistance fromLabel(String label) {
        if(label == null || label.trim().isEmpty()) {
            throw new InvalidSessionAssistanceException("null or empty");
        }
        String trimmedLabel = label.trim();
        for (SessionAssistance status : values()) {
            if( status.label.equalsIgnoreCase(trimmedLabel)) {
                return status;
            }
        }
        throw new InvalidSessionAssistanceException(label);
    }
}