package dto.student;

import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import entity.participant.student.studentEnum.AlumniType;
import entity.participant.student.studentEnum.Degree;
import entity.participant.student.studentEnum.StudyYear;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class StudentRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 20, message = "Name must be 2 - 20 chars long")
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(min = 2, max = 20, message = "Surname must be 2 - 20 chars long")
    private String surname;

    @Size(max = 20, message = "Surname must be 20 chars long max")
    private String secondSurname;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "RGPD status is required")
    private RGPD_Status rgpdStatus;

    @Size(max = 3, message = "Max 3 extra emails")
    private Set<@Email(message = "Invalid email format") String> extraEmails;

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