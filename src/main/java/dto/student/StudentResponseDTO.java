package dto.student;

import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import entity.participant.student.studentEnum.AlumniType;
import entity.participant.student.studentEnum.Degree;
import entity.participant.student.studentEnum.ServiceAwareness;
import entity.participant.student.studentEnum.StudyYear;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class StudentResponseDTO {
    private Long id;
    private String name;
    private String surname;
    private String secondSurname;
    private String email;
    private RGPD_Status rgpdStatus;
    private Set<String> extraEmails;
    private Degree degree;
    private StudyYear studyYear;
    private Boolean isAlumni;
    private AlumniType alumniType;
    private ServiceAwareness serviceAwareness;
    private String serviceAwarenessDisplayLabel;
    private LocalDate firstContactDate;
    private String personalObservation;
}