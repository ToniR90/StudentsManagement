package entity.participant.participantEnum;

import exception.personalException.InvalidRGPDStatusException;

public enum RGPD_Status {
    SIGNET("Signet") ,
    NOT_SIGNET("Not signet") ,
    PENDING("Pending");

    private final String label;

    RGPD_Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static RGPD_Status fromLabel(String label) {
        for (RGPD_Status status : values()) {
            if( status.label.equalsIgnoreCase(label)) {
                return status;
            }
        }
        throw new InvalidRGPDStatusException(label);
    }
}