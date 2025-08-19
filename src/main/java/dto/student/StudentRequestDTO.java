package dto.student;

import dto.participant.ParticipantRequestDTO;
import entity.participant.student.studentEnum.AlumniType;
import entity.participant.student.studentEnum.Degree;
import entity.participant.student.studentEnum.StudyYear;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentRequestDTO extends ParticipantRequestDTO {

    @NotNull(message = "Degree is required")
    private Degree degree;

    @NotNull(message = "Study year is required")
    private StudyYear studyYear;

    @NotNull(message = "Is alumni?")
    private Boolean isAlumni;

    private AlumniType alumniType;

    @Valid
    @NotNull(message = "Service Awareness is required")
    private ServiceAwarenessSelection serviceAwarenessSelection;

    @NotNull(message = "First contact date is required")
    private LocalDate firstContactDate;

    @Size(max = 2000, message = "Max 2000 chars for observations")
    private String personalObservation;
}