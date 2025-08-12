package entity.participant.student.studentEnum;

import exception.personalException.InvalidAlumniTypeException;
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

    public final AlumniType fromLabel(String label) {
        for(AlumniType status : values()) {
            if(status.label.equalsIgnoreCase(label)) {
                return status;
            }
        }
        throw new InvalidAlumniTypeException(label);
    }
}
