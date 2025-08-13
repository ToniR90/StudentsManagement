package entity.participant.student.studentEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceAwareness {
    GROUP_SESSION("Group individualSession: ") ,
    MAILING("Mailing: ") ,
    MOODLE("Moodle: ") ,
    COLLEAGUE("Colleague: ") ,
    PDI_PAS("PDI_PAS: ") ,
    OTHER("Other: ");

    private final String label;
}
