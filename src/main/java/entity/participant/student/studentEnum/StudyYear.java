package entity.participant.student.studentEnum;

import exception.personalException.InvalidStudyYearException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum StudyYear {
    FIRST("First year") ,
    SECOND("Second year") ,
    THIRD("Third year") ,
    FOURTH("Fourth year") ,
    FIFTH("Fifth year") ,
    SIXTH("Sixth year");

    private final String label;

    public static StudyYear fromLabel(String label) {
        if(label == null || label.trim().isEmpty()) {
            throw new InvalidStudyYearException("null or empty");
        }
        return Arrays.stream(values())
                .filter(y -> y.label.equalsIgnoreCase(label.trim()))
                .findFirst()
                .orElseThrow(() -> new InvalidStudyYearException(label));
    }
}
