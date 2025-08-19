package entity.participant.student;

import entity.participant.abstractParticipant.Participant;
import entity.participant.student.studentEnum.AlumniType;
import entity.participant.student.studentEnum.Degree;
import entity.participant.student.studentEnum.ServiceAwareness;
import entity.participant.student.studentEnum.StudyYear;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Participant {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "degree")
    private Degree degree;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "study_year")
    private StudyYear studyYear;

    @NotNull
    @Column(name = "is_alumni" , nullable = false)
    private boolean isAlumni;

    @Enumerated(EnumType.STRING)
    @Column(name = "alumni_type")
    private AlumniType alumniType;

    @NotNull(message = "Service awareness cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "service_awareness" , nullable = false)
    private ServiceAwareness serviceAwareness;

    @NotNull(message = "First contact date is required")
    @Column(name = "first_contact_date" , nullable = false)
    private LocalDate firstContactDate;

    @Size(max = 500 , message = "Maximum 500 characters allowed")
    @Column(name = "personal_observations")
    private String personalObservation;
}
