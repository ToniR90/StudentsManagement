package entity.session.individualSession.individualSessionEnum;

import exception.personalException.InvalidSessionAssistanceException;
import exception.personalException.InvalidSessionTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SessionType {
    IN_PERSON("In person session") ,
    ONLINE("Online Session");

    private final String label;

    public static SessionType fromLabel(String label) {
        if(label == null || label.trim().isEmpty()) {
            throw new InvalidSessionTypeException("null or empty");
        }
        String trimmedLabel = label.trim();
        for (SessionType status : values()) {
            if( status.label.equalsIgnoreCase(trimmedLabel)) {
                return status;
            }
        }
        throw new InvalidSessionTypeException(label);
    }
}
