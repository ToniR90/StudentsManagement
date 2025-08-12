package entity.session.abstractSession.sessionEnum;

import exception.personalException.InvalidSessionTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SessionType {
    INDIVIDUAL("Individual session") ,
    GROUP_SESSION("Group session");

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
