package entity.session.individualSession.individualSessionEnum;

import exception.personalException.InvalidSessionAssistanceException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SessionAssistance {
    YES("Yes") ,
    NO("No") ,
    NO_ADVICE("No, but they have informed");

    private final String label;

    public static SessionAssistance fromLabel(String label) {
        for (SessionAssistance status : values()) {
            if( status.label.equalsIgnoreCase(label)) {
                return status;
            }
        }
        throw new InvalidSessionAssistanceException(label);
    }
}
