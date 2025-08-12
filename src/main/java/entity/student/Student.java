package entity.student;

import entity.Participant;
import entity.Session;
import entity.student.studentEnum.*;
import jakarta.persistence.Column;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@SuperBuilder
public class Student extends Participant {

    @Column(name = "degree" , nullable = false)
    private Degree degree;

    @Column(name = "study_year")
    private StudyYear studyYear;

    @Column(name = "is_alumni" , nullable = false)
    private boolean isAlumni;

    @Column(name = "alumni_type")
    private AlumniType alumniType;

    @Column(name = "service_awareness" , nullable = false)
    private ServiceAwareness serviceAwareness;

    @Column(name = "first_contact_date" , nullable = false)
    private LocalDate firstContactDate;

    @Column(name = "personal_observations")
    private String personalObservation;

    @Column(name = "rgpd_status")
    private RGPD_Status rgpdStatus;


}
