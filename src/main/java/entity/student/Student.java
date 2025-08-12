package entity.student;

import entity.Participant;
import entity.Session;
import entity.student.studentEnum.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@SuperBuilder
public class Student extends Participant {
    private Degree degree;
    private StudyYear studyYear;
    private boolean isAlumni;
    private AlumniType alumniType;
    private ServiceAwareness serviceAwareness;
    private LocalDate firstContactDate;
    private String personalObservation;
    private RGPD_Status rgpd_status;
    private List<Session> sessionList;
}
