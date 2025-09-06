package com.university.management.entity.participant.student.studentEnum;

import com.university.management.exception.personalException.InvalidServiceAwarenessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceAwareness {
    GROUP_SESSION("Group Session: ") ,
    MAILING("Mailing: ") ,
    MOODLE("Moodle: ") ,
    COLLEAGUE("Colleague: ") ,
    PDI_PAS("PDI_PAS: ") ,
    OTHER("Other: ");

    private final String label;

    public static ServiceAwareness fromLabel(String label) {
        if(label == null || label.trim().isEmpty()) {
            throw new InvalidServiceAwarenessException("null or empty");
        }
        for(ServiceAwareness status : values()) {
            if(status.label.equalsIgnoreCase(label)) {
                return status;
            }
        }
        throw new InvalidServiceAwarenessException(label);
    }
}
