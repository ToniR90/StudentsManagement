package com.university.management.entity.participant.abstractParticipant.participantEnum;

import com.university.management.exception.personalException.InvalidRGPDStatusException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RGPD_Status {
    SIGNET("Signet") ,
    SIGNET_ONLINE("Signet online") ,
    NOT_SIGNET("Not signet") ,
    PENDING("Pending");

    private final String label;

    public static RGPD_Status fromLabel(String label) {
        if(label == null) throw new InvalidRGPDStatusException("null");
        for (RGPD_Status status : values()) {
            if( status.label.equalsIgnoreCase(label)) {
                return status;
            }
        }
        throw new InvalidRGPDStatusException(label);
    }
}