package dto.student;

import dto.participant.ParticipantResponseDTO;
import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import entity.participant.student.studentEnum.AlumniType;
import entity.participant.student.studentEnum.Degree;
import entity.participant.student.studentEnum.ServiceAwareness;
import entity.participant.student.studentEnum.StudyYear;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
public class StudentResponseDTO extends ParticipantResponseDTO {
    private Degree degree;
    private StudyYear studyYear;
    private Boolean isAlumni;
    private AlumniType alumniType;
    private ServiceAwareness serviceAwareness;
    private String serviceAwarenessDisplayLabel;
    private LocalDate firstContactDate;
    private String personalObservation;
}