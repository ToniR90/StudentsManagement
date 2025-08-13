package entity.session.individualSession.individualSessionEnum;

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
        for (SessionType status : values()) {
            if( status.label.equalsIgnoreCase(label)) {
                return status;
            }
        }
        throw new InvalidSessionTypeException(label);
    }
}
